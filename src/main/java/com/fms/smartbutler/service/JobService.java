package com.fms.smartbutler.service;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Job;
import com.fms.smartbutler.repository.JobRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobService {
	
	private final JobRepository jobRepository;
	
	public void saveJob(Job job) {
		jobRepository.save(job);
	}
}
