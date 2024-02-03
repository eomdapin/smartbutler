package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-01-31
*/

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
	
	public boolean save(CostDTO costDTO) {
		Optional<Cost> findCost = costRepository.findByBuild_BuildIdAndDate(costDTO.getBuildId(), costDTO.getDate());
		
		if(findCost.isEmpty()) {
			Cost cost = modelMapper.map(costDTO, Cost.class);
			costRepository.save(cost);
		} else {
			costDTO.setCostId(findCost.get().getCostId());
			return true;
		}
		return false;
	}
	
	public void updateCost(CostDTO costDTO) {
		Cost cost = modelMapper.map(costDTO, Cost.class);
		costRepository.save(cost);
	}
	
	public CostDTO findById(Long costId) {
		Cost cost = costRepository.findById(costId).orElseGet(Cost::new);
		return modelMapper.map(cost, CostDTO.class); 
	}
	
	public List<CostDTO> findByBuildId(Long buildId) {
		return costRepository.findByBuild_BuildIdOrderByDateDesc(buildId).stream()
				.map(cost -> modelMapper.map(cost, CostDTO.class)).toList();
	}
	
	public CostDTO findByBuildIdAndDate(Long buildId, LocalDate date) {
		Optional<Cost> cost = costRepository.findByBuild_BuildIdAndDate(buildId, date);
		if(cost.isEmpty()) {
			return null;
		} else {
			return modelMapper.map(cost.get(), CostDTO.class); 
		}
	}
	
	public List<CostDTO> findAllByDate(LocalDate date) {
		return costRepository.findAllByDate(date).stream().map(c ->
			modelMapper.map(c, CostDTO.class)).toList();
				
	}
}
