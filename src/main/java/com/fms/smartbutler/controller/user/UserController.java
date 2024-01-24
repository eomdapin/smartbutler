package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;

	@GetMapping("/user/join")
	public String getJoin(Model model) {
		return "user/join/join";
	}
	
	@PostMapping("/user/login")
	public String postJoin(@ModelAttribute User user, User.UserLogin userLogin, Model model) {
		log.info(userLogin.getPw());
		userService.save(user, userLogin);
		return "redirect:/user/login";
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
