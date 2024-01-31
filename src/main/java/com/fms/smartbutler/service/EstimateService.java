package com.fms.smartbutler.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Estimate;
import com.fms.smartbutler.dto.EstimateDTO;
import com.fms.smartbutler.repository.EstimateRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class EstimateService {
	
	private final EstimateRepository estimateRepository;
	private final ModelMapper modelMapper;
	
	public void insert(EstimateDTO estimateDTO) {
		Estimate estimate = modelMapper.map(estimateDTO, Estimate.class);
		
		estimateRepository.save(estimate);
		estimateDTO.setEstimateId(estimate.getEstimateId());
	}
	
}
