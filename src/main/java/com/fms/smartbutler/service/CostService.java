package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Cost;
import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.formdto.CostFormDTO;
import com.fms.smartbutler.repository.CostRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

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
	
	public boolean save(CostFormDTO costDTO) {
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
	
	public boolean updateCost(CostDTO costDTO) {
		if(costDTO.getResidentCnt() != null && costDTO.getResidentCnt() < 1) {
			return false;
		}
		
		Cost cost = modelMapper.map(costDTO, Cost.class);
		
		costRepository.save(cost);
		
		return true;
	}
	
	public CostDTO findById(Long costId) {
		Cost cost = costRepository.findById(costId).orElseGet(Cost::new);
		
		return modelMapper.map(cost, CostDTO.class); 
	}
	
	public Page<CostDTO> findByBuildId(Long buildId, Pageable pageable) {
		if(buildId == null || buildId == 0) {
			return costRepository.findAllByOrderByDateDesc(pageable)
					.map(cost -> modelMapper.map(cost, CostDTO.class));
		} else {
			return costRepository.findAllByBuild_BuildIdOrderByDateDesc(buildId, pageable)
					.map(cost -> modelMapper.map(cost, CostDTO.class));
		}
	}
	
	public List<CostDTO> findByBuildIdUser(Long buildId) {
		return costRepository.findByBuild_BuildIdAndSendOrderByDateDesc(buildId, 2).stream()
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
