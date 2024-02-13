package com.fms.smartbutler.controller.admin;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String getEstimateList(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by("estimateId").descending());
		Page<EstimateDTO> estimates = estimateService.findByAllPage(pageable);
		
		model.addAttribute("list", estimates);
		
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
	public String postEstimateInfo(@ModelAttribute EstimateDTO estimateDTO) {
		estimateService.update(estimateDTO);
		
		return "redirect:/admin/estimates";
	}
}
