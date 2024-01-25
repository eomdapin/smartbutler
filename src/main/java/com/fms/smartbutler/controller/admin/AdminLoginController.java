package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	
	// 관리자 로그인 폼
	@GetMapping("/login")
	public String getlogin() {
		return "admin/login/login";
	}
	
}
