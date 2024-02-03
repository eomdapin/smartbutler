package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.dto.EstimateDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ClaimService;
import com.fms.smartbutler.service.CostService;
import com.fms.smartbutler.service.EstimateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminMainController {
	
	private final BuildService buildService;
	private final EstimateService estimateService;
	private final ClaimService claimService; 
	private final CostService costService;
	
	@GetMapping("/admin")
	public String getAdminMainPage(Model model) {
		List<BuildDTO> builds = buildService.findAll();
		List<EstimateDTO> estimates = estimateService.findAllByConfirm(1);
		List<ClaimDTO> claims = claimService.findAllByStatus(1);
		
		int estimateCnt = estimates.size();
		int claimCnt = claims.size();
		
		model.addAttribute("estimates", estimates);
		model.addAttribute("estimateCnt", estimateCnt);
		model.addAttribute("claims", claims);
		model.addAttribute("claimCnt", claimCnt);
		
		return "admin/main/main";
	}
}
