package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminLoginController {
	
	// 관리자 로그인 폼
	@GetMapping("/login")
	public String getlogin() {
		return "admin/login/login";
	}
	
}
