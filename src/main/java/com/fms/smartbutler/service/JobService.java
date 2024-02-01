package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Job;
import com.fms.smartbutler.dto.JobDTO;
import com.fms.smartbutler.repository.JobRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class JobService {
	
	private final JobRepository jobRepository;
	private final ModelMapper modelMapper;
	
	public void insert(JobDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
		jobDTO.setJobId(job.getJobId());
	}
	
	public void update(JobDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
		jobDTO.setJobId(job.getJobId());
	}
	
	public List<JobDTO> findAll() {
		List<Job> jobList = jobRepository.findAll();
		List<JobDTO> jobDTOList = jobList
									.stream()
									.map(j -> modelMapper.map(j, JobDTO.class))
									.collect(Collectors.toList());
		
		return jobDTOList;
	}
	
	public Page<JobDTO> findAll(Pageable pageable) {
		Pageable reversePageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("jobId").descending());
		Page<Job> jobPage = jobRepository.findAllByOrderByJobIdDesc(reversePageable);
		Page<JobDTO> jobDTOPage = jobPage.map(j -> modelMapper.map(j, JobDTO.class));
		
		return jobDTOPage;
	}
	
	public List<JobDTO> findByBuildId(Long buildId) {
		List<Job> jobList;
		
		if(buildId == 0) {
			jobList = jobRepository.findAll();
		} else {
			jobList = jobRepository.findByBuild_BuildId(buildId);
		}
		
		List<JobDTO> jobDTOList = jobList
									.stream()
									.map(j -> modelMapper.map(j, JobDTO.class))
									.collect(Collectors.toList());
		
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
