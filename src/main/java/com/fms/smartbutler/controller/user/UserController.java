package com.fms.smartbutler.controller.user;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fms.smartbutler.dto.User;
import com.fms.smartbutler.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	// 회원 가입
	@GetMapping("/user/join")
	public String getJoin(Model model) {
		return "user/join/join";
	}
	
	// 회원가입 완료
	@PostMapping("/user/login")
	public String postJoin(@ModelAttribute User user, User.UserLogin userLogin, Model model) {
		userService.save(user, userLogin);
		return "redirect:/user/login";
	}
	
	// 내 정보
	@GetMapping("/user/mypage")
	public String getMypage(Model model) {
		Optional<User> user = userService.findByUserId(1L);
		model.addAttribute("user", user.get());
		return "user/mypage/mypage";
	}
	
	// 내정보 수정
	@PostMapping("/user/mypage")
	public String postMypage(HttpSession session, @ModelAttribute User user, User.UserLogin userLogin, Model model) {
		return "redirect:/user/mypage";
	}
	
	// 견적 신청
	@GetMapping("/user/estimate")
	public String estimate() {
		return "user/estimate/estimate-add";
	}
}
