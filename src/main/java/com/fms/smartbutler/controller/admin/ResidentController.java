package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResidentController {
	
	@GetMapping("/admin/{buildId}/resident/list/{residentId}")
	public String residentInfo() {
		return "admin/resident/resident-info";
	}
	
	@GetMapping("/admin/{buildId}/resident/list")
	public String residentList() {
		return "admin/resident/resident-list";
	}
	
	@GetMapping("/admin/{buildId}/resident/list/{residentId}/update")
	public String updateResidentInfoForm() {
		return "admin/resident/update-resident-info";
	}
	
	@PostMapping("/admin/{buildId}/resident/list/{residentId}/update")
	public String updateResidentInfo() {
		return "redirect:/admin/{buildId}/resident/list";
	}
	
	@PostMapping("/admin/{buildId}/resident/list/{residentId}/delete")
	public String deleteResidentInfo() {
		return "redirect:/admin/{buildId}/resident/list";
	}
	
	@GetMapping("/admin/{buildId}/resident/list/add")
	public String addResidentInfoForm() {
		return "admin/resident/add-resident-info";
	}
	
	@PostMapping("/admin/{buildId}/resident/list/{residentId}/add")
	public String addResidentInfo() {
		return "redirect:/admin/{buildId}/resident/list";
	}
	

}
