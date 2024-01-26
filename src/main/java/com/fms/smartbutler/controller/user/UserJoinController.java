package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.User;
import com.fms.smartbutler.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/join")
@RequiredArgsConstructor
public class UserJoinController {
	
	private final UserService userService;
	
	// 회원 가입
	@GetMapping
	public String getJoin(Model model) {
		return "user/join/join";
	}
	
	// 회원가입 완료
	@PostMapping("/success")
	public String postJoin(@ModelAttribute User user, Model model) {
		userService.save(user);
		return "user/join/join-success";
	}
}