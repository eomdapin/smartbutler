package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JobController {
	@GetMapping("/admin/{buildId}/job/list")
	public String JobList() {
		return "admin/jobList";
	}
	
	@GetMapping("admin/{buildId}/job/list/{jobId}")
	public String JobInfo() {
		return "admin/jobInfo";
	}
}
