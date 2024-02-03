package com.fms.smartbutler.controller.admin;

/**
* @author 엄다빈
* @editDate 2024-02-01 ~ 2024-02-02
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ResidentService;
import com.fms.smartbutler.service.UsersService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/buildings")
public class ResidentController {
	
	private final BuildService buildService;
	private final UsersService usersService;
	private final ResidentService residentService;
	
	// 입주 목록
	@GetMapping("/{buildId}/residents")
	public String getResidentList(@PathVariable Long buildId, Model model) {
		List<ResidentDTO> residents = residentService.findAllByEnteredAndBuildId(2L, buildId);
		List<BuildDTO> builds = buildService.findAll();
		BuildDTO build = buildService.findById(buildId);
		
		model.addAttribute("residents", residents);
		model.addAttribute("buildId", buildId);
		model.addAttribute("builds", builds);
		model.addAttribute("build", build);
		
		return "admin/resident/resident-list";
	}
	
	// 입주 등록 폼
	@GetMapping("/{buildId}/residents/add")
	public String getResidentInfoForm(@PathVariable Long buildId, Model model) {
		List<UsersDTO> users = usersService.findAll();
		List<BuildDTO> builds = buildService.findAll();
		List<ResidentDTO> residents = residentService.findAllByEnteredAndBuildId(1L, buildId);
		
		model.addAttribute("resident", new ResidentDTO());
		model.addAttribute("residents", residents);
		model.addAttribute("buildId", buildId);
		model.addAttribute("users", users);
		model.addAttribute("builds", builds);
		
		return "admin/resident/resident-add";
	}
	
	// 입주 등록
	@PostMapping("/{buildId}/residents/add")
	public String postResidentInfo(@ModelAttribute ResidentDTO residentDTO, @PathVariable Long buildId) {
		UsersDTO updateUser = usersService.findById(residentDTO.getUserId()).orElseGet(UsersDTO::new);
		updateUser.setStatus(2);
		residentService.save(residentDTO);
		usersService.updateStatus(updateUser);
		
		return "redirect:/admin/buildings/{buildId}/residents";
	}
	
	// 입주 상세
	@GetMapping("/{buildId}/residents/{residentId}")
	public String getResidentInfo(@PathVariable Long buildId, @PathVariable Long residentId, Model model) {
		ResidentDTO resident = residentService.findById(residentId);
		model.addAttribute("resident", resident);
		
		return "admin/resident/resident-info";
	}
	
	// 입주 수정 폼
	@GetMapping("/{buildId}/residents/{residentId}/update")
	public String getUpdateResidentInfoForm(@PathVariable Long buildId, @PathVariable Long residentId, Model model) {
		ResidentDTO resident = residentService.findById(residentId);
		model.addAttribute("resident", resident);
		
		return "admin/resident/resident-edit";
	}
	
	// 입주 수정
	@PutMapping("/{buildId}/residents/{residentId}")
	public String postUpdateResidentInfo(@ModelAttribute ResidentDTO residentDTO, @PathVariable Long buildId) {
		residentService.save(residentDTO);
		
		return "redirect:/admin/buildings/{buildId}/residents";
	}
	
	// 입주 삭제
	@DeleteMapping("{buildId}/residents/{residentId}")
	public String deleteResidentInfo(@ModelAttribute ResidentDTO residentDTO, @PathVariable Long buildId) {
		log.info("residentDTO.getResidentId() :: {} ", residentDTO.getResidentId());
		residentService.deleteResident(residentDTO);
		
		return "redirect:/admin/buildings/{buildId}/residents";
	}
	
	// 입주 현황
	@GetMapping("/{buildId}/residents/total")
	public String getResidentsTotal(@PathVariable Long buildId, Model model) {
		List<BuildDTO> builds = buildService.findAll();
		BuildDTO build = buildService.findById(buildId);
		
		model.addAttribute("builds", builds);
		model.addAttribute("build", build);
		
		return "admin/resident/resident-total";
	}
}
