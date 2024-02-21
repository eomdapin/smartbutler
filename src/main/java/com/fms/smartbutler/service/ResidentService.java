package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-02-01 ~ 2024-02-02
*/

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Resident;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.formdto.ResidentFormDTO;
import com.fms.smartbutler.repository.ResidentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ResidentService {
	
	private final ResidentRepository residentRepository;
	private final ModelMapper modelMapper;
	
	public void save(ResidentFormDTO residentDTO) {
		residentDTO.getBuild().setBuildId(residentDTO.getBuildId());
		residentDTO.getUsers().setUserId(residentDTO.getUserId());
		
		Resident resident = modelMapper.map(residentDTO, Resident.class);
		
		residentRepository.save(resident);
	}
	
	public ResidentDTO findById(Long residentId) {
		Resident resident = residentRepository.findById(residentId).orElseGet(Resident::new);
		ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
		
		residentDTO.setUsers(resident.getUsers());
		residentDTO.setBuild(resident.getBuild());
		
		return residentDTO;
	}
	
	public ResidentDTO findByUserId(Long userId) {
		Resident resident = residentRepository.findTopByUsers_UserId(userId).orElseGet(Resident::new);
		ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
		
		residentDTO.setUsers(resident.getUsers());
		residentDTO.setBuild(resident.getBuild());
		
		return residentDTO;
	}
	
	public void deleteResident(ResidentDTO residentDTO) {
		residentDTO.getBuild().setBuildId(residentDTO.getBuildId());
		residentDTO.getUsers().setUserId(residentDTO.getUserId());
		Resident resident = modelMapper.map(residentDTO, Resident.class);
		
		residentRepository.delete(resident);
	}
	
	public List<ResidentDTO> findAll() {
		 List<ResidentDTO> residentList = residentRepository.findAll().stream()
				.map(resident -> {
					ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
					residentDTO.setUsers(resident.getUsers());
					residentDTO.setBuild(resident.getBuild());
					return residentDTO;
				}).toList();
		 
		 return residentList;
	}
	
	public List<ResidentDTO> findAllByEnteredAndBuildId(Long entered, Long buildId) {
		if(buildId == null || buildId == 0) {
			return residentRepository.findAllByEntered(entered).stream()
				.map(resident -> {
					ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
					residentDTO.setUsers(resident.getUsers());
					residentDTO.setBuild(resident.getBuild());
					return residentDTO;
				}).toList();
		} else {
			return residentRepository.findAllByEnteredAndBuild_BuildId(entered, buildId).stream()
					.map(resident -> {
						ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
						residentDTO.setUsers(resident.getUsers());
						residentDTO.setBuild(resident.getBuild());
						return residentDTO;
					}).toList();
		}
	}
}
