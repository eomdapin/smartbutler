package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.service.BuildService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/buildings")
public class ResidentController {
	
	private final BuildService buildService;
	
	// 입주 상세
	@GetMapping("/{buildId}/residents/{residentId}")
	public String getResidentInfo() {
		return "admin/resident/resident-info";
	}
	
	// 입주 목록
	@GetMapping("/{buildId}/residents")
	public String getResidentList() {
		return "admin/resident/resident-list";
	}
	
	// 입주 수정 폼
	@GetMapping("/{buildId}/residents/{residentId}/update")
	public String getUpdateResidentInfoForm() {
		return "admin/resident/update-resident-info";
	}
	
	// 입주 수정
	@PostMapping("/{buildId}/residents/{residentId}/update")
	public String postUpdateResidentInfo() {
		return "redirect:/admin/{buildId}/resident/list";
	}
	
	// 입주 삭제
	@PostMapping("/{buildId}/residents/{residentId}/delete")
	public String deleteResidentInfo() {
		return "redirect:/admin/{buildId}/resident/list";
	}
	
	// 입주 등록 폼
	@GetMapping("/{buildId}/residents/add")
	public String getResidentInfoForm() {
		return "admin/resident/add-resident-info";
	}
	
	// 입주 등록
	@PostMapping("/{buildId}/residents/{residentId}/add")
	public String postResidentInfo() {
		return "redirect:/admin/{buildId}/resident/list";
	}
	
	/**
	* @author 엄다빈
	* @editDate 2024-01-29 ~ 2024-01-29
	*/
	// 입주 현황
	@GetMapping("/{buildId}/residents/total")
	public String getResidentsTotal(@PathVariable Long buildId, Model model) {
		List<Build> builds = buildService.findAll();
		log.info("buildId :: {}", buildId);
		Build build = buildService.findById(buildId).orElseGet(Build::new);
		
		model.addAttribute("builds", builds);
		model.addAttribute("build", build);
		
		return "admin/resident/resident-total";
	}
}
