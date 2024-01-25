package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/estimates")
public class EstimateController {
	
	// 견적 목록
	@GetMapping
	public String estimateList() {
		return "admin/estimate/estimate-list";
	}
	
	// 견적 상세
	@GetMapping("/info")
	public String estimateInfo() {
		return "admin/estimate/estimate-info";
	}
	
}
