package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.Image;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user/buildings")
@RequiredArgsConstructor
public class UserBuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 건물 정보
	@GetMapping("/info")
	public String getBuildInfo(@RequestParam(required = false) Long BuildId, Model model) {
		BuildId = BuildId == null ? 1 :BuildId;
		Build build = buildService.findById(BuildId).orElseGet(Build::new);
		
		
		model.addAttribute("build", build);
		
		return "user/build/build-info";
	}
}
