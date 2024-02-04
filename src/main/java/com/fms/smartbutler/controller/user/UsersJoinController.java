package com.fms.smartbutler.controller.user;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/join")
@RequiredArgsConstructor
public class UsersJoinController {
	
	private final UsersService usersService;
	
	// 회원 가입
	@GetMapping
	public String getJoin() {
		return "user/join/join";
	}
	
	// 회원가입 완료
	@PostMapping("/success")
	public String postJoin(@ModelAttribute UsersDTO usersDTO) {
		usersService.insert(usersDTO);
		
		return "redirect:/user/join/success";
	}
	
	// 회원가입 성공
	@GetMapping("/success")
	public String getJoinSuccess() {
		return "user/join/join-success";
	}
}