package com.fms.smartbutler.controller.user;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.User;
import com.fms.smartbutler.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	// 회원 가입
	@GetMapping("/join")
	public String getJoin(Model model) {
		return "user/join/join";
	}
	
	// 회원가입 완료
	@PostMapping("/login")
	public String postJoin(@ModelAttribute User user, User.UserLogin userLogin, Model model) {
		userService.save(user, userLogin);
		return "redirect:/user/login";
	}
	
	// 내 정보
	@GetMapping("/mypage")
	public String getMypage(Model model) {
		Optional<User> user = userService.findByUserId(1L);
		model.addAttribute("user", user.get());
		return "user/mypage/mypage";
	}
	
	// 내정보 수정
	@PostMapping("/mypage")
	public String postMypage(HttpSession session, @ModelAttribute User user, User.UserLogin userLogin, Model model) {
		return "redirect:/user/mypage";
	}
	
	// 견적 신청 -> 컨트롤러 분리
	@GetMapping("/estimate")
	public String estimate() {
		return "user/estimate/estimate-add";
	}
}
