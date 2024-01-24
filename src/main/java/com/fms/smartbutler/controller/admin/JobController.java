package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JobController {
	
//	private final JobService jobService;
	
	// 작업 목록
	@GetMapping("/admin/{buildId}/job/list")
	public String getJobList(@PathVariable Long buildId) {
		return "admin/job/job-list";
	}
	
	// 작업 상세
	@GetMapping("admin/{buildId}/job/list/{jobId}")
	public String getJobInfo(@PathVariable("buildId") Long buildId, @PathVariable("jobId") Long jobId) {
		return "admin/job/job-info";
	}
	
	// 작업 등록 폼
	@GetMapping("admin/{buildId}/job/add")
	public String getJobAdd(@PathVariable Long buildId) {
		return "admin/job/job-add";
	}
	
	// 작업 등록
	@PostMapping("admin/{buildId}/job/add")
	public String postJobAdd(@PathVariable Long buildId) {
		return "redirect:/admin/" + buildId + "/job/list";
	}
}
