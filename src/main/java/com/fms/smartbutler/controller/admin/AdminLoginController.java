package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminLoginController {
	
	@GetMapping("/admin/login")
	public String getlogin() {
		return "admin/login/login";
	}
	
	@GetMapping("/admin/{buildId}/resident/list/{residentId}")
	public String residentInfo() {
		return "admin/resident/residentInfo";
	}
	
	@GetMapping("/admin/{buildId}/resident/list")
	public String residentList() {
		return "admin/resident/residentList";
	}
	
}
