package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.ResidentService;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {
	
	private final UsersService usersService;
	private final ResidentService residentService;
	
	// 회원 정보
	@GetMapping
	public String getUserList(Model model) {
		List<UsersDTO> user = usersService.findAll();
		
		model.addAttribute("user", user);
		
		return "admin/user/user-list";
	}
	
	// 회원 정보 상세
	@GetMapping("/{userId}")
	public String getUserInfo(@PathVariable Long userId, Model model) {
		UsersDTO user = usersService.findById(userId).orElseGet(UsersDTO::new);
		ResidentDTO resident = residentService.findByUserId(user.getUserId());
		
		model.addAttribute("user", user);
		model.addAttribute("resident", resident);
		
		return "admin/user/user-info";
	}
	
	// 회원 탈퇴
	@DeleteMapping("/{userId}/delete")
	public String postUserDelete(@PathVariable Long userId, @ModelAttribute UsersDTO usersDTO) {
		usersService.delete(usersDTO);
		
		return "redirect:/admin/users";
	}
}
