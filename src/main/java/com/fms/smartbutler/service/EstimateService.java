package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	
	public void update(EstimateDTO estimateDTO) {
		Estimate estimate = modelMapper.map(estimateDTO, Estimate.class);
		
		estimateRepository.save(estimate);
		estimateDTO.setEstimateId(estimate.getEstimateId());
	}
	
	public Optional<EstimateDTO> findById(Long estimateId) {
		Optional<Estimate> estimate = estimateRepository.findById(estimateId);
		EstimateDTO estimateDTO = modelMapper.map(estimate, EstimateDTO.class);
		
		return Optional.ofNullable(estimateDTO);
	}
	
	public List<EstimateDTO> findAll() {
		List<Estimate> estimateList = estimateRepository.findAll();
		List<EstimateDTO> estimateDTOList = estimateList
												.stream()
												.map(e ->
													modelMapper
													.map(e, EstimateDTO.class))
													.collect(Collectors.toList());
		return estimateDTOList;
	}
	
	public List<EstimateDTO> findAllByConfirm(int confirm) {
		return estimateRepository.findAllByConfirm(confirm).stream().map(e ->
				modelMapper.map(e, EstimateDTO.class)
				).toList();
	}
	
}
