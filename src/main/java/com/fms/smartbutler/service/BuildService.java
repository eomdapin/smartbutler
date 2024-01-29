package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-01-23 ~ 2024-01-24
*/

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.repository.BuildRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BuildService {
	
	private final BuildRepository buildRepository;
	
	public void insert(Build build) {
		buildRepository.save(build);
	}
	
	public void update(Build build) {
		buildRepository.save(build);
	}
	
	public Optional<Build> findById(Long buildId) {
		return buildRepository.findById(buildId);
	}
	
	public List<Build> findAll() {
		return buildRepository.findAll();
	}
}
