package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class AdminUserController {
	
	private final UserService userService;
	
	// 회원 정보 조회
	@GetMapping("/admin/user/list")
	public String userList(Model model) {
		List<User> user = userService.findAllUser();
		
		model.addAttribute("user", user);
		
		return "admin/user/user-list";
	}
	
	// 회원 정보 상세
	@GetMapping("/admin/user/list/{userId}")
	public String userInfo(@PathVariable Long userId, Model model) {
		User user = userService.findByUserId(userId).orElseGet(User::new);
		
		model.addAttribute("user", user);
		
		return "admin/user/user-info";
	}
	
	// 회원 탈퇴
	@PostMapping("/admin/user/list/{userId}/delete")
	public String userDelete(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return "redirect:/admin/user/list";
	}
}
