package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserBuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	@GetMapping("/user/build/info")
	public String getBuildInfo() {
		return "user/build/build-info";
	}
}
