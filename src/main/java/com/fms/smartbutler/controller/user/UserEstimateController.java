package com.fms.smartbutler.controller.user;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.EstimateDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.EstimateService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/estimate")
@RequiredArgsConstructor
public class UserEstimateController {
	
	private final EstimateService estimateService;
	private final BuildService buildService;
	
	// 견적 신청 폼
	@GetMapping
	public String getEstimate(@RequestParam(required = false) Long buildId, Model model) {
		buildId = buildId == null ? 1 :buildId;
		BuildDTO buildDTO = buildService.findById(buildId);
		List<BuildDTO> build = buildService.findAll();
		
		model.addAttribute("build", buildDTO);
		model.addAttribute("builds", build);
		
		return "user/estimate/estimate-add";
	}
	
	// 견적 신청
	@PostMapping("/success")
	public String postEstimate(@ModelAttribute EstimateDTO estimateDTO) throws Exception {
		estimateService.insert(estimateDTO);
		
		return "redirect:/user/estimate/success";
	}
	
	// 견적신청 완료
	@GetMapping("/success")
	public String getEstimateSuccess(Model model) {
		return "user/estimate/estimate-success";
	}
}
