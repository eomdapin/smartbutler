package com.fms.smartbutler.controller.admin;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
	
	@PostMapping("/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout"; //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
}
