package com.fms.smartbutler.controller.user;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UsersService usersService;
	
	// 내 정보
	//@GetMapping("/mypage/{userId}")
	@GetMapping("/mypage")
	public String getMypage(Model model) {
		Optional<UsersDTO> user = usersService.findById(2L);
		
		model.addAttribute("user", user.get());
		
		return "user/mypage/mypage";
	}
	
	// 내정보 수정
	//@PostMapping("/mypage/{userId}")
	@PostMapping("/mypage")
	public String postMypage(@ModelAttribute UsersDTO usersDTO, Model model) {
		usersService.update(usersDTO);
		return "redirect:/user/mypage";
	}
	
}
