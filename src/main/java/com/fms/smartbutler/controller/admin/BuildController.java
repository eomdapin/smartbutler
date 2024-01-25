package com.fms.smartbutler.controller.admin;

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
		List<Build> build = buildService.findAll();
		
		model.addAttribute("build", build);
		
		return "admin/build/build-list";
	}
	
	// 건물 정보 상세
	@GetMapping("/{buildId}")
	public String getBuildInfo(@PathVariable Long buildId, Model model) {
		Build build = buildService.findById(buildId).orElseGet(Build::new);
		Image image = imageService.findById(build.getImgId()).orElseGet(Image::new);
		FileVo vo = new FileVo();
		
		vo.setFileName(image.getRealName());
		model.addAttribute("build", build);
		model.addAttribute("vo", vo);
		
		return "admin/build/build-info";
	}
	
	// 건물 정보 입력 폼
	@GetMapping("/add")
	public String getBuildAdd(Model model) {
		model.addAttribute("build", new Build());
		
		return "admin/build/build-info";
	}
	
	// 건물 정보 저장
	@PostMapping("/add")
	public String postBuildAdd(@ModelAttribute Build build, @ModelAttribute FileVo vo, Model model) throws Exception {
		Image image = new Image();
		
		imageService.saveImage(vo, image);
		
		build.setImgId(image.getImageId());
		buildService.insert(build);
		
		return "redirect:/admin/build/list";
	}
	
	// 건물 정보 수정
	@PostMapping("/{buildId}/insert") // PutMapping으로 변경 시 insert 문구 삭제 예정
	public String postBuildinsert(@ModelAttribute Build build, FileVo vo, Model model) throws Exception {
		Image image = new Image();
		
		buildService.update(build);
		
		image.setImageId(build.getImgId());
		imageService.updateImage(vo, image);
		
		return "redirect:/admin/build/list";
	}
}
