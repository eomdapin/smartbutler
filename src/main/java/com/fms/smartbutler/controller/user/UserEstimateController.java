package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserEstimateController {
	
	// 견적 신청
	@GetMapping("/estimate")
	public String estimate() {
		return "user/estimate/estimate-add";
	}

}
