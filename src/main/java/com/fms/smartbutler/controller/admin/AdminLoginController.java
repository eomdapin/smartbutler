package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	
	// 관리자 로그인 폼
	@GetMapping("/login")
	public String getlogin() {
		return "admin/login/login";
	}
	
	// 관리자 로그인
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		return "/";
	}
	
}
