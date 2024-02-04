package com.fms.smartbutler.controller.worker;

/**
 * @author 송창민
 * @editDate 2024-02-02 ~ 2024-02-03
 */

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

import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.dto.JobDTO;
import com.fms.smartbutler.service.CompanyService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.service.JobService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {
	
	private final JobService jobService;
	private final CompanyService companyService;
	private final ImageService imageService;
	
	// 작업 목록
	@GetMapping("/jobs")
	public String getJobList(@RequestParam(defaultValue = "0") int page, Principal principal, Model model) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by("jobId").descending());
		CompanyDTO company = companyService.findByName(principal.getName()).orElseGet(CompanyDTO::new);
		Page<JobDTO> jobs = jobService.findByCompanyId(company.getCompanyId(), pageable);
 
		model.addAttribute("list", jobs);
		return "worker/job/job-list";
	}
	
	// 작업 상세
	@GetMapping("/jobs/{jobId}")
	public String getJobInfo(@PathVariable("jobId") Long jobId, Principal principal, Model model) {
		JobDTO job = jobService.findById(jobId).orElseGet(JobDTO::new);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(job.getJobId(), "j");
		CompanyDTO company = companyService.findByName(principal.getName()).orElseGet(CompanyDTO::new);
		FileVo vo = new FileVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("job", job);
		model.addAttribute("images", images);
		model.addAttribute("company", company);
		model.addAttribute("vo", vo);
		
		return "worker/job/job-info";
	}
	
	// 작업 완료
	@PutMapping("/jobs/{jobId}")
	public String putJobInfo(@ModelAttribute JobDTO jobDTO, @ModelAttribute FileVo vo) throws Exception {
		jobService.finishJob(jobDTO);
		
		if(!vo.getFileName().isEmpty()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setCoded("j");
			imageService.saveImage(vo, imageDTO, jobDTO.getJobId());
		}
		
		return "redirect:/worker/jobs";
	}
}
