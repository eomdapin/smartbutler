package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.dto.ItemDTO;
import com.fms.smartbutler.dto.JobDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CompanyService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.service.ItemService;
import com.fms.smartbutler.service.JobService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class JobController {
	
	private final JobService jobService;
	private final ImageService imageService;
	private final BuildService buildService;
	private final ItemService itemService;
	private final CompanyService companyService;
	
	// 작업 목록
	@GetMapping("/{buildId}/jobs")
	public String getJobList(@PathVariable Long buildId, @RequestParam(defaultValue = "0") int page, Model model) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by("jobId").descending());
		List<BuildDTO> builds = buildService.findAll();
		BuildDTO build = buildService.findById(buildId);
		Page<JobDTO> jobs = jobService.findByBuildId(buildId, pageable);
 
		model.addAttribute("list", jobs);
		model.addAttribute("builds", builds);
		model.addAttribute("build", build);
		model.addAttribute("buildId", (buildId == 0 || buildId == null) ? 0L : buildId);
		
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
		BuildDTO build = buildService.findById(buildId);
		List<ItemDTO> items = itemService.findAll();
		List<BuildDTO> builds = buildService.findAll();
		List<CompanyDTO> companies = companyService.findAll();
		
		model.addAttribute("build", build);
		model.addAttribute("items", items);
		model.addAttribute("builds", builds);
		model.addAttribute("companies", companies);
		model.addAttribute("buildId", (buildId == 0 || buildId == null) ? 0L : buildId);

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
