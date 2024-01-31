package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
	
	public Optional<JobDTO> findById(Long jobId) {
		Optional<Job> job = jobRepository.findById(jobId);
		JobDTO jobDTO = modelMapper.map(job, JobDTO.class);
		
		return Optional.ofNullable(jobDTO);
	}
}
