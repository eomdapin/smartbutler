package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/buildings")
public class ResidentController {
	
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
}
