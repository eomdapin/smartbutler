package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.dto.JobDTO;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.service.JobService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class JobController {
	
	private final JobService jobService;
	private final ImageService imageService;
	
	// 작업 목록
	@GetMapping("/{buildId}/jobs")
	public String getJobList(@PathVariable Long buildId, Model model) {
		List<JobDTO> jobs = jobService.findAll();
		
		model.addAttribute("jobs", jobs);
		
		return "admin/job/job-list";
	}
	
	// 작업 상세
	@GetMapping("/{buildId}/jobs/{jobId}")
	public String getJobInfo(@PathVariable("buildId") Long buildId, @PathVariable("jobId") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId).orElseGet(JobDTO::new);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(job.getJobId(), "j");
		FileVo vo = new FileVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("job", job);
		model.addAttribute("images", images);
		model.addAttribute("vo", vo);
		
		return "admin/job/job-info";
	}
	
	// 작업 등록 폼
	@GetMapping("/{buildId}/jobs/add")
	public String getJobAdd(@PathVariable Long buildId, Model model) {
		JobDTO job = new JobDTO();
		
		model.addAttribute("job", job);
		model.addAttribute("buildId", buildId);
		
		return "admin/job/job-add";
	}
	
	// 작업 등록
	@PostMapping("/{buildId}/jobs/add")
	public String postJobAdd(@PathVariable Long buildId, @ModelAttribute JobDTO jobDTO) {
		jobService.insert(jobDTO);
		
		return "redirect:/admin/buildings/{buildId}/jobs";
	}
	
	// 작업 삭제
	@DeleteMapping("/{buildId}/jobs/{jobId}")
	public String deleteJob(@PathVariable Long buildId, @ModelAttribute JobDTO jobDTO) {
		jobService.delete(jobDTO);
		
		return "redirect:/admin/buildings/{buildId}/jobs";
	}
	
	// 작업 수정 폼
	@GetMapping("/{buildId}/jobs/{jobId}/edit")
	public String getJobEdit(@PathVariable Long buildId, @PathVariable Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId).orElseGet(JobDTO::new);

		model.addAttribute("job", job);
		
		return "admin/job/job-edit";
	}
	
	// 작업 수정
	@PutMapping("/{buildId}/jobs/{jobId}/edit")
	public String putJobEdit(@PathVariable Long buildId, @ModelAttribute JobDTO jobDTO) {
		jobService.update(jobDTO);
		
		return "redirect:/admin/buildings/{buildId}/jobs/{jobId}";
	}
}
