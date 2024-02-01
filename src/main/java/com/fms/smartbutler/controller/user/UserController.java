package com.fms.smartbutler.controller.user;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/mypage/{userId}")
@RequiredArgsConstructor
public class UserController {
	
	private final UsersService usersService;
	
	// 내 정보
	@GetMapping
	public String getMypage(@PathVariable Long userId, Model model) {
		Optional<UsersDTO> user = usersService.findById(2L);
		
		model.addAttribute("user", user.get());
		
		return "user/mypage/mypage";
	}
	
	// 내정보 수정 폼
	@GetMapping("/edit")
	public String getMypageEdit(@PathVariable Long userId, Model model) {
		UsersDTO user = usersService.findById(userId).orElseGet(UsersDTO::new);
		
		model.addAttribute("user", user);
		
		return "user/mypage/mypage-edit";
	}
	
	// 내정보 수정
	@PutMapping("/edit")
	public String postMypageEdit(@PathVariable Long userId, @ModelAttribute UsersDTO usersDTO, Model model) throws Exception {
		usersService.update(usersDTO);
		
		return "redirect:/user/mypage/{userId}";
	}
	
}
