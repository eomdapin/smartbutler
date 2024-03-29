package com.fms.smartbutler.service;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
*/

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	public Page<EstimateDTO> findByAllPage(Pageable pageable) {
		Page<Estimate> estimate = estimateRepository.findAllByOrderByEstimateIdDesc(pageable);
		Page<EstimateDTO> estimateDTO = estimate.map(e -> modelMapper.map(e, EstimateDTO.class));
		
		return estimateDTO;
	}
	
	public Optional<EstimateDTO> findById(Long estimateId) {
		Optional<Estimate> estimate = estimateRepository.findById(estimateId);
		EstimateDTO estimateDTO = modelMapper.map(estimate, EstimateDTO.class);
		
		return Optional.ofNullable(estimateDTO);
	}
	
	public List<EstimateDTO> findAll() {
		return estimateRepository.findAll().stream().map(e ->
			modelMapper.map(e, EstimateDTO.class)).collect(Collectors.toList());
	}
	
	public List<EstimateDTO> findAllByConfirm(int confirm) {
		return estimateRepository.findAllByConfirm(confirm).stream().map(e ->
				modelMapper.map(e, EstimateDTO.class)).collect(Collectors.toList());
	}
}
