package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-01-31
*/

import java.security.Principal;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CostService;
import com.fms.smartbutler.service.ResidentService;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserCostController {	
	
	private final CostService costService;
	private final BuildService buildService;
	private final UsersService usersService;
	private final ResidentService residentService;
	
	// 사용자 관리비 조회
	@GetMapping("/user/cost")
	public String getUserCost(Principal principal,
			@RequestParam(required = false) Long costId, Model model) {
		UsersDTO user = usersService.findByEmail(principal.getName()).orElseGet(UsersDTO::new);
		
		if(user.getStatus() < 2) {
			return "user/cost/cost-error";
		}
		
		ResidentDTO resident = residentService.findByUserId(user.getUserId());
		Long buildId = resident.getBuildId();
		List<CostDTO> costs = costService.findByBuildIdUser(buildId);
		
		if(costs.size() < 1) {
			return "user/cost/cost-error-no-send";
		}
		
		BuildDTO build = buildService.findById(buildId);
		
		costId = costId == null ? costs.get(0).getCostId() : costId;
		CostDTO cost = costService.findById(costId);
		CostDTO prevCost = costService.findByBuildIdAndDate(buildId, cost.getDate().minusMonths(1));
		
		model.addAttribute("costs", costs);
		model.addAttribute("cost", cost);
		model.addAttribute("prevCost", prevCost);
		model.addAttribute("build", build);
		
		return "user/cost/cost-info";
	}
}
