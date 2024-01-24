package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fms.smartbutler.dto.Build;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 건물 정보 조회
	@GetMapping("/admin/build/list")
	public String getBuildList(Model model) {
		List<Build> build = buildService.findAll();
		
		model.addAttribute("build", build);
		
		return "admin/build/build-list";
	}
	
	// 건물 정보 상세
	@GetMapping("/admin/build/list/{buildId}")
	public String getBuildInfo(@PathVariable Long buildId, Model model) {
		Build build = buildService.findById(buildId).orElseGet(Build::new);
		
		model.addAttribute("build", build);
		
		return "admin/build/build-info";
	}
	
	// 건물 정보 입력
	@GetMapping("/admin/build/add")
	public String getBuildAdd(Model model) {
		model.addAttribute("build", new Build());
		
		return "admin/build/build-info";
	}
	
	// 건물 정보 저장
	@PostMapping("/admin/build/add")
	public String postBuildAdd(@ModelAttribute Build build, @ModelAttribute FileVo vo, Model model) throws Exception {
		buildService.insert(build);
		imageService.saveImage(vo);
		
		return "redirect:/admin/build/list";
	}
	
	// 건물 정보 수정
	@PostMapping("/admin/build/list/{buildId}/insert") // PutMapping으로 변경 시 insert 문구 삭제 예정
	public String postBuildinsert(@ModelAttribute Build build, Model model) {
		buildService.update(build);
		
		return "redirect:/admin/build/list";
	}
}
