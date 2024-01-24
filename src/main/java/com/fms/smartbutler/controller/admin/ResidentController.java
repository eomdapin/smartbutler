package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String updateResidentInfo() {
		return "admin/resident/update-resident-info";
	}
	
	@GetMapping("/admin/{buildId}/resident/list/delete")
	public String deleteResidentInfo() {
		return "admin/resident/delete-resident-info";
	}
	
	@GetMapping("/admin/resident/new")
	public String addResidentInfo() {
		return "admin/resident/add-resident-info";
	}

}
