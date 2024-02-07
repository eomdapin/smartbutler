package com.fms.smartbutler.controller.user;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.ResidentService;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/mypage")
@RequiredArgsConstructor
public class UserController {
	
	private final UsersService usersService;
	private final ResidentService residentService;
	
	// 내 정보
	@GetMapping
	public String getMypage(Principal principal, Model model) {
		UsersDTO user = usersService.findByEmail(principal.getName()).orElseGet(UsersDTO::new);
		ResidentDTO resident = residentService.findByUserId(user.getUserId());
		
		model.addAttribute("user", user);
		model.addAttribute("resident", resident);
		
		return "user/mypage/mypage";
	}
	
	// 내정보 수정 폼
	@GetMapping("/edit")
	public String getMypageEdit(Principal principal, Model model) {
		UsersDTO user = usersService.findByEmail(principal.getName()).orElseGet(UsersDTO::new);
		ResidentDTO resident = residentService.findByUserId(user.getUserId());
		
		model.addAttribute("user", user);
		model.addAttribute("resident", resident);
		
		return "user/mypage/mypage-edit";
	}
	
	// 내정보 수정
	@PutMapping("/edit")
	public String postMypageEdit(@ModelAttribute UsersDTO usersDTO, Model model) throws Exception {
		usersService.update(usersDTO);
		
		return "redirect:/user/mypage";
	}
}
