package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	// 사용자 로그인 폼
	@GetMapping("/login")
	public String getLogin() {
		return "user/login/login";
	}
}
