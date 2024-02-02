package com.fms.smartbutler.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Resident;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.repository.BuildRepository;
import com.fms.smartbutler.repository.ResidentRepository;
import com.fms.smartbutler.repository.UsersRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
@RequiredArgsConstructor
public class ResidentService {
	
	private final ResidentRepository residentRepository;
	private final BuildRepository buildRepository;
	private final UsersRepository usersRepository;
	private final ModelMapper modelMapper;
	
	public void save(ResidentDTO residentDTO) {
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
		Resident resident = residentRepository.findByUser_UserId(userId).orElseGet(Resident::new);
		
		ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
		residentDTO.setUsers(resident.getUsers());
		residentDTO.setBuild(resident.getBuild());
		
		return residentDTO;
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
		List<ResidentDTO> residentList = residentRepository.findAllByEnteredAndBuild_BuildId(entered, buildId).stream()
				.map(resident -> {
					ResidentDTO residentDTO = modelMapper.map(resident, ResidentDTO.class);
					residentDTO.setUsers(resident.getUsers());
					residentDTO.setBuild(resident.getBuild());
					return residentDTO;
				}).toList();
		
		return residentList;
	}
}
