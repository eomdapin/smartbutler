package com.fms.smartbutler.controller.user;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	
	// 사용자 로그인 폼
	@GetMapping("/login")
	public String getlogin() {
		return "user/login/login";
	}
}
