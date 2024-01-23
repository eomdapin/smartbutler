package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/join")
	public String join() {
		return "user/join/join";
	}
	
	@GetMapping("/user/mypage")
	public String mypage() {
		return "user/mypage/mypage";
	}
	
	@GetMapping("/user/estimate")
	public String estimate() {
		return "user/estimate/estimate-add";
	}
	
	@GetMapping("/user/build/info")
	public String getBuildInfo() {
		return "user/build/build-info";
	}
}
