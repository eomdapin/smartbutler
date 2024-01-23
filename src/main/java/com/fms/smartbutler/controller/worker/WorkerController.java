package com.fms.smartbutler.controller.worker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WorkerController {
	
	@GetMapping("/worker/job/list")
	public String getJobList() {
		return "worker/job/job-list";
	}
	
	@GetMapping("/worker/job/list/{jobId}")
	public String getJobInfo() {
		return "worker/job/job-info";
	}
	
	@PostMapping("/worker/job/list/{jobId}")
	public String postJobInfo() {
		return "redirect:/worker/job/list";
	}
}
