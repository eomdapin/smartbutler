package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminMainController {
	
	@GetMapping("/admin")
	public String getAdminMainPage() {
		
		
		 return "admin/main/main";
	}
}
