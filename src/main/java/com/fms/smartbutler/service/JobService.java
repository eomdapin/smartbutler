package com.fms.smartbutler.service;

/**
 * @author 송창민
 * @editDate 2024-01-31 ~ 2024-02-02
 */

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Job;
import com.fms.smartbutler.dto.JobDTO;
import com.fms.smartbutler.formdto.JobFormDTO;
import com.fms.smartbutler.repository.JobRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class JobService {
	
	private final JobRepository jobRepository;
	private final ModelMapper modelMapper;
	
	public void insert(JobFormDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
	}
	
	public void update(JobDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
		jobDTO.setJobId(job.getJobId());
	}
	
	public void finishJob(JobDTO jobDTO) {
		jobDTO.setFinDate(Date.valueOf(LocalDate.now()));
		jobDTO.setStatus(2);
		
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
		jobDTO.setJobId(job.getJobId());
	}
	
	public Page<JobDTO> findByBuildId(Long buildId, Pageable pageable) {
		if(buildId == 0) {
			return jobRepository.findAllByOrderByJobIdDesc(pageable)
					.map(j -> modelMapper.map(j, JobDTO.class));
		} else {
			return jobRepository.findByBuild_BuildIdOrderByJobIdDesc(buildId, pageable)
					.map(j -> modelMapper.map(j, JobDTO.class));
		}
	}
	
	public Page<JobDTO> findByCompanyId(Long companyId, Pageable pageable) {
		Page<Job> jobList = jobRepository.findByCompany_CompanyIdOrderByJobIdDesc(companyId, pageable);
		Page<JobDTO> jobDTOList = jobList.map(j -> modelMapper.map(j, JobDTO.class));
		
		return jobDTOList;
	}
	
	public Optional<JobDTO> findById(Long jobId) {
		Optional<Job> job = jobRepository.findById(jobId);
		JobDTO jobDTO = modelMapper.map(job, JobDTO.class);
		
		return Optional.ofNullable(jobDTO);
	}
	
	public void delete(JobDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.delete(job);
	}
}
