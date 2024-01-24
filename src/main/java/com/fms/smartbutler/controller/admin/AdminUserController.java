package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminUserController {
	
	private final UserService userService;
	
	// 건물 정보 조회
	@GetMapping("/admin/user/list")
	public String userList(Model model) {
		List<User> user = userService.findAllUser();
		
		model.addAttribute("user", user);
		
		return "admin/user/user-list";
	}
	
	@GetMapping("/admin/user/info")
	public String userInfo() {
		return "admin/user/user-info";
	}
}
