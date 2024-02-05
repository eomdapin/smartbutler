package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-01-31
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserCostController {	
	
	private final CostService costService;
	private final BuildService buildService;
	
	// 사용자 관리비 조회
	@GetMapping("/user/cost")
	public String getUserCost(@RequestParam(required = false) Long buildId, @RequestParam(required = false) Long costId, Model model) {
		buildId = buildId == null ? 1 :buildId;
		List<CostDTO> costs = costService.findByBuildId(buildId);
		BuildDTO build = buildService.findById(buildId);
		
		costId = costId == null ? costs.get(0).getCostId() : costId;
		CostDTO cost = costService.findById(costId);
		CostDTO prevCost = costService.findByBuildIdAndDate(buildId, cost.getDate().minusMonths(1));
		
		model.addAttribute("costs", costs);
		model.addAttribute("cost", cost);
		model.addAttribute("prevCost", prevCost);
		model.addAttribute("build", build);
		
		return "/user/cost/cost-info";
	}
}
