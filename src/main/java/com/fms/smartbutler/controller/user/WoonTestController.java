package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WoonTestController {

	@GetMapping("/user/join")
	public String join() {
		return "user/join";
	}
	
	@GetMapping("/admin/user/list")
	public String userList() {
		return "admin/user-list";
	}
	
	@GetMapping("/admin/user/info")
	public String userInfo() {
		return "admin/user-info";
	}
	
	@GetMapping("/user/mypage")
	public String mypage() {
		return "user/mypage";
	}
}
