package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstimateController {

	@GetMapping("/admin/estimate/list")
	public String estimateList() {
		return "admin/user/estimate-list";
	}
	
	@GetMapping("/admin/estimate/info")
	public String estimateInfo() {
		return "admin/user/estimate-info";
	}
	
}
