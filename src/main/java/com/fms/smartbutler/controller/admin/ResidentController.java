package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResidentController {
	
	@GetMapping("/admin/{buildId}/resident/list/{residentId}")
	public String residentInfo() {
		return "admin/resident/residentInfo";
	}
	
	@GetMapping("/admin/{buildId}/resident/list")
	public String residentList() {
		return "admin/resident/residentList";
	}
	
	@GetMapping("/admin/{buildId}/resident/list/{residentId}/update")
	public String updateResidentInfo() {
		return "admin/resident/updateResidentInfo";
	}
	
	@GetMapping("/admin/{buildId}/resident/list/delete")
	public String deleteResidentInfo() {
		return "admin/resident/deleteResidentInfo";
	}
	
	@GetMapping("/admin/resident/new")
	public String addResidentInfo() {
		return "admin/resident/addResidentInfo";
	}

}
