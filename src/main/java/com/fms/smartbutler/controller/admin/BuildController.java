package com.fms.smartbutler.controller.admin;

/**
* @author 엄다빈
* @editDate 2024-01-23 ~ 2024-01-24
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.Image;
import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class BuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 건물 정보
	@GetMapping
	public String getBuildList(Model model) {
		List<BuildDTO> build = buildService.findAll();
		
		model.addAttribute("build", build);
		
		return "admin/build/build-list";
	}
	
	// 건물 정보 상세
	@GetMapping("/{buildId}")
	public String getBuildInfo(@PathVariable Long buildId, Model model) {
		BuildDTO build = buildService.findById(buildId);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(build.getBuildId(), "b");
		FileVo vo = new FileVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("build", build);
		model.addAttribute("vo", vo);
		
		return "admin/build/build-info";
	}
	
	// 건물 정보 입력 폼
	@GetMapping("/add")
	public String getBuildAdd(Model model) {
		model.addAttribute("build", new BuildDTO());
		
		return "admin/build/build-info";
	}
	
	// 건물 정보 저장
	@PostMapping("/add")
	public String postBuildAdd(@ModelAttribute BuildDTO build, @ModelAttribute FileVo vo, Model model) throws Exception {
		buildService.insert(build);
		
		if(!vo.getFileName().isEmpty()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setCoded("b");
			imageService.saveImage(vo, imageDTO, build.getBuildId());
		}
		
		return "redirect:/admin/buildings";
	}
	
	// 건물 정보 수정
	@PostMapping("/{buildId}/update") // PutMapping으로 변경 시 update 문구 삭제 예정
	public String postBuildinsert(@ModelAttribute BuildDTO build, @ModelAttribute FileVo vo, Model model) throws Exception {
		buildService.insert(build);
		
		if(vo.getFileName() != null && !vo.getFileName().isEmpty()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setCoded("b");
			imageService.saveImage(vo, imageDTO, build.getBuildId());
		} 
		
		return "redirect:/admin/buildings";
	}
}
