package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminUserController {
	
	@GetMapping("/admin/user/list")
	public String userList() {
		return "admin/user/user-list";
	}
	
	@GetMapping("/admin/user/info")
	public String userInfo() {
		return "admin/user/user-info";
	}
}
