package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
	@GetMapping("/admin/{buildId}/job/list")
	public String getJobList(@PathVariable Long buildId) {
		return "admin/job/job-list";
	}
	
	@GetMapping("admin/{buildId}/job/list/{jobId}")
	public String getJobInfo(@PathVariable("buildId") Long buildId, @PathVariable("jobId") Long jobId) {
		return "admin/job/job-info";
	}
	
	@GetMapping("admin/{buildId}/job/add")
	public String getJobAdd(@PathVariable Long buildId) {
		return "admin/job/job-add";
	}
	
	@PostMapping("admin/{buildId}/job/add")
	public String postJobAdd(@PathVariable Long buildId) {
		return "redirect:/admin/" + buildId + "/job/list";
	}
}
