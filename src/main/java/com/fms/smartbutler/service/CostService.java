package com.fms.smartbutler.service;

import java.util.List;

import org.modelmapper.ModelMapper;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Cost;
import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.repository.CostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CostService {
	
	private final CostRepository costRepository;
	private final ModelMapper modelMapper;
	
	public List<CostDTO> findAll() {
		return costRepository.findAll().stream()
				.map(cost -> modelMapper.map(cost, CostDTO.class)).toList();
	}
	
	public void save(CostDTO costDTO) {
		Cost cost = modelMapper.map(costDTO, Cost.class);
		costRepository.save(cost);
	}
	
	public CostDTO findById(Long costId) {
		Cost cost = costRepository.findById(costId).orElseGet(Cost::new);
		return modelMapper.map(cost, CostDTO.class); 
	}
}
