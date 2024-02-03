package com.fms.smartbutler.controller.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.domain.Admin;
import com.fms.smartbutler.dto.AdminDTO;
import com.fms.smartbutler.repository.AdminRepository;
import com.fms.smartbutler.service.AdminService;

import lombok.RequiredArgsConstructor;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserLoginController {
	
	// 사용자 로그인 폼
	@GetMapping("/login")
	public String getlogin() {
		return "user/login/login";
	}
	
	// 사용자 로그인
	@PostMapping("/login")
	public String login() {
		return "/";
	}
	
}
