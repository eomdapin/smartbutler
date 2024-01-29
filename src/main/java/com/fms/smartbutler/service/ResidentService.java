package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Resident;
import com.fms.smartbutler.repository.ResidentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ResidentService {
	
	private final ResidentRepository residentRepository;
	
	public Optional<Resident> findById(Long residentId) {
		return residentRepository.findById(residentId);
	}
	
	public List<Resident> findAll() {
		return residentRepository.findAll();
	}
}
