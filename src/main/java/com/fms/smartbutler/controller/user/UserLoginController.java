package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

	@GetMapping("user/login")
	public String getLogin() {
		return "user/login/login";
	}
}
