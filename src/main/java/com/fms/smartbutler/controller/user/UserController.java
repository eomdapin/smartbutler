package com.fms.smartbutler.controller.user;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.User;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final BuildService buildService;
	
	// 내 정보
	//@GetMapping("/mypage/{userId}")
	@GetMapping("/mypage")
	public String getMypage(Model model) {
		Optional<User> user = userService.findById(2L);
		//Optional<Build> build = buildService.findById(1L);
		
		model.addAttribute("user", user.get());
		//model.addAttribute("build", build.get());
		
		return "user/mypage/mypage";
	}
	
	// 내정보 수정
	//@PostMapping("/mypage/{userId}")
	@PostMapping("/mypage")
	public String postMypage(@ModelAttribute User user, Model model) {
		userService.save(user);
		return "redirect:/user/mypage";
	}
	
}
