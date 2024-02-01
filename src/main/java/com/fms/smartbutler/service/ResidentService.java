package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Resident;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.repository.ResidentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class ResidentService {
	
	private final ResidentRepository residentRepository;
	private final ModelMapper modelMapper;
	
	public Optional<Resident> findById(Long residentId) {
		return residentRepository.findById(residentId);
	}
	
	public List<ResidentDTO> findAll() {
		 log.info("residentRepository.findAll().get(0).getUsers().getUserName() ::: {}", residentRepository.findAll().get(0).getUsers().getUserName());
		
		return residentRepository.findAll().stream()
				.map(resident -> modelMapper.map(resident, ResidentDTO.class)).toList();
	}
}
