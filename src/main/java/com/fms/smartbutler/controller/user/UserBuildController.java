package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.Build;
import com.fms.smartbutler.dto.Image;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserBuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	@GetMapping("/user/build/info")
	public String getBuildInfo(@RequestParam(required = false) Long BuildId, Model model) {
		BuildId = BuildId == null ? 1 :BuildId;
		Build build = buildService.findById(BuildId).orElseGet(Build::new);
		
		Image image = imageService.findById(build.getImgId()).orElseGet(Image::new);
		
		model.addAttribute("build", build);
		model.addAttribute("image", image);
		
		return "user/build/build-info";
	}
}
