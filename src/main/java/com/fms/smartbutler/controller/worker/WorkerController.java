package com.fms.smartbutler.controller.worker;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.dto.JobDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CompanyService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.service.JobService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {
	
	private final JobService jobService;
	private final CompanyService companyService;
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 작업 목록
	@GetMapping("/jobs")
	public String getJobList(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, Principal principal, Model model) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("jobId").descending());
		List<BuildDTO> builds = buildService.findAll();
		CompanyDTO company = companyService.findByName(principal.getName()).orElseGet(CompanyDTO::new);
//		BuildDTO build = buildService.findById(buildId);
		Page<JobDTO> jobs = jobService.findByCompanyId(company.getCompanyId(), pageable);
 
		model.addAttribute("list", jobs);
		model.addAttribute("builds", builds);
//		model.addAttribute("build", build);
//		model.addAttribute("buildId", (buildId == 0 || buildId == null) ? 0L : buildId);
		return "worker/job/job-list";
	}
	
	// 작업 상세
	@GetMapping("/jobs/{jobId}")
	public String getJobInfo(@PathVariable("jobId") Long jobId, Model model) {
		JobDTO job = jobService.findById(jobId).orElseGet(JobDTO::new);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(job.getJobId(), "j");
		FileVo vo = new FileVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("job", job);
		model.addAttribute("images", images);
		model.addAttribute("vo", vo);
		
		return "worker/job/job-info";
	}
	
	// 작업 완료
	@PutMapping("/jobs/{jobId}")
	public String putJobInfo(@ModelAttribute JobDTO jobDTO, @ModelAttribute FileVo vo) throws Exception {
		jobService.insert(jobDTO);
		
		if(!vo.getFileName().isEmpty()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setCoded("j");
			imageService.saveImage(vo, imageDTO, jobDTO.getJobId());
		}
		
		return "redirect:/worker/jobs";
	}
}
