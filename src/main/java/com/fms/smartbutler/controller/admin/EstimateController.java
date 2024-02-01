package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.EstimateDTO;
import com.fms.smartbutler.service.EstimateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/estimates")
@RequiredArgsConstructor
public class EstimateController {
	
	private final EstimateService estimateService;
	
	// 견적 목록
	@GetMapping
	public String getEstimateList(Model model) {
		List<EstimateDTO> estimate = estimateService.findAll();
		
		model.addAttribute("estimate", estimate);
		
		return "admin/estimate/estimate-list";
	}
	
	// 견적 상세
	@GetMapping("/{estimateId}")
	public String getEstimateInfo(@PathVariable("estimateId") Long estimateId, Model model) {
		EstimateDTO estimate = estimateService.findById(estimateId).orElseGet(EstimateDTO::new);
		
		model.addAttribute("estimate", estimate);
		
		return "admin/estimate/estimate-info";
	}
	
	// 견적 완료
	@PostMapping("/{estimateId}")
	public String postEstimateInfo(@ModelAttribute EstimateDTO estomateDTO) {
		estimateService.update(estomateDTO);
		
		return "redirect:/admin/estimates";
	}
	
}
