package com.fms.smartbutler.controller.worker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/worker")
public class WorkerController {
	
	// 작업 목록
	@GetMapping("/jobs")
	public String getJobList() {
		return "worker/job/job-list";
	}
	
	// 작업 상세
	@GetMapping("/jobs/{jobId}")
	public String getJobInfo() {
		return "worker/job/job-info";
	}
	
	// 작업 완료
	@PostMapping("/jobs/{jobId}")
	public String postJobInfo() {
		return "redirect:/worker/jobs";
	}
}
