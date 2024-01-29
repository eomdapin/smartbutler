package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-01-25 ~ 2024-01-29
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.domain.Image;
import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user/buildings")
@RequiredArgsConstructor
public class UserBuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 건물 정보
	@GetMapping("/info")
	public String getBuildInfo(@RequestParam(required = false) Long buildId, Model model) {
		buildId = buildId == null ? 1 :buildId;
		BuildDTO build = buildService.findById(buildId);
		List<BuildDTO> builds = buildService.findAll();
		List<Image> images = imageService.findByOutIdAndCoded(build.getBuildId(), "b");
		
		model.addAttribute("build", build);
		model.addAttribute("builds", builds);
		model.addAttribute("images", images);
		
		return "user/build/build-info";
	}
}
