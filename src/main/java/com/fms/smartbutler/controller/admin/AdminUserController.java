package com.fms.smartbutler.controller.admin;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String getUserList(@RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by("userId").descending());
		Page<UsersDTO> users = usersService.findByAllPage(pageable);
		
		model.addAttribute("list", users);
		
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
	@DeleteMapping("/{userId}")
	public String deleteUserInfo(@ModelAttribute UsersDTO usersDTO) {
		usersService.delete(usersDTO);
		
		return "redirect:/admin/users";
	}
}
