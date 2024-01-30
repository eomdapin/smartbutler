package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

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
	
	public void save(JobDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
	}
	
	public void update(JobDTO jobDTO) {
		Job job = modelMapper.map(jobDTO, Job.class);
		
		jobRepository.save(job);
	}
	
	public List<JobDTO> findAll() {
		jobRepository.findAll();
		
		return null;
	}
	
	public Optional<JobDTO> findById(Long jobId) {
		jobRepository.findById(jobId);
		
		return null;
	}
}
