package com.fms.smartbutler.controller.admin;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.domain.Admin;
import com.fms.smartbutler.dto.AdminDTO;
import com.fms.smartbutler.repository.AdminRepository;
import com.fms.smartbutler.service.AdminService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminLoginController {
	
	private final ModelMapper modelMapper;
	private final AdminService adminService;
	
	// 관리자 로그인 폼
	@GetMapping("/login")
	public String getlogin() {
		return "admin/login/login";
	}
	
	// 관리자 로그인
	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("password", password);
		return "/";
	}
	
	@GetMapping("/join")
	public String joinAdmin() {
		return "admin/login/join-admin";
	}
	
	@PostMapping("/join/{role}")
	public String createMember(@ModelAttribute AdminDTO adminDTO, Model model) {
		// DTO to Entity
		Admin entity = modelMapper.map(adminDTO, Admin.class);
		
		// save
		//Member savedEntity = memberRepository.save(entity);
		Admin savedEntity = adminService.joinMember(entity);
		
		// Entity to DTO
		AdminDTO savedDTO = modelMapper.map(savedEntity, AdminDTO.class);
		
		model.addAttribute("admin", savedDTO);
		
		return "admin/login/join-success";	// join/success
	}
	
}
