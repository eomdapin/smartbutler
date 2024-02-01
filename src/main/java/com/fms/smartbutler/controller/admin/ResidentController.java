package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ResidentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/buildings")
public class ResidentController {
	
	private final BuildService buildService;
	private final ResidentService residentService;
	
	// 입주 목록
	@GetMapping("/{buildId}/residents")
	public String getResidentList(@PathVariable Long buildId, Model model) {
		List<ResidentDTO> residents = residentService.findAll();
		
		log.info(">>>> {}", residents.get(0).getUsers().getUserName());
		
		model.addAttribute("residents", residents);
		model.addAttribute("buildId", buildId);
		
		return "admin/resident/resident-list";
	}
	
	// 입주 등록 폼
	@GetMapping("/{buildId}/residents/add")
	public String getResidentInfoForm(@PathVariable Long buildId, Model model) {
		model.addAttribute("resident", new ResidentDTO());
		model.addAttribute("buildId", buildId);
		
		return "admin/resident/resident-add";
	}
	
	// 입주 등록
	@PostMapping("/{buildId}/residents/add")
	public String postResidentInfo() {
		return "redirect:/admin/buildings/{buildId}/residents";
	}
	
	// 입주 상세
	@GetMapping("/{buildId}/residents/{residentId}")
	public String getResidentInfo() {
		return "admin/resident/resident-info";
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
	
	// 입주 현황
	@GetMapping("/{buildId}/residents/total")
	public String getResidentsTotal(@PathVariable Long buildId, Model model) {
		List<BuildDTO> builds = buildService.findAll();
		BuildDTO build = buildService.findById(buildId);
		
		model.addAttribute("builds", builds);
		model.addAttribute("build", build);
		
		return "admin/resident/resident-total";
	}
}
