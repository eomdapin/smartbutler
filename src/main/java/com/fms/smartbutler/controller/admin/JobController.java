package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
	@GetMapping("/admin/{buildId}/job/list")
	public String getJobList() {
		return "admin/job/job-list";
	}
	
	@GetMapping("admin/{buildId}/job/list/{jobId}")
	public String getJobInfo() {
		return "admin/job/job-info";
	}
	
	@GetMapping("admin/{buildId}/job/add")
	public String getJobAdd() {
		return "admin/job/job-add";
	}
	
	@PostMapping("admin/{buildId}/job/add")
	public String postJobAdd() {
		return "redirect:/admin/1/job/list";
	}
}
