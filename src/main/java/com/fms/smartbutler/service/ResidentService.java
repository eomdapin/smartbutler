package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-02-01 ~ 2024-02-02
*/

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Resident;
import com.fms.smartbutler.dto.ResidentDTO;
import com.fms.smartbutler.repository.ResidentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ResidentService {
	
	private final ResidentRepository residentRepository;
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
		Resident resident = residentRepository.findByUsers_UserId(userId).orElseGet(Resident::new);
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
		
		resident = new Resident();
		resident.setBuild(residentDTO.getBuild());
		resident.setResidentNum(residentDTO.getResidentNum());
		resident.setEntered(1);
		
		residentRepository.save(resident);
	}
	
	public void addResidentDefault(Long buildId, Integer floor, Integer room) {
		List<ResidentDTO> residentDTOList = new ArrayList<>();
		
		for(int i = 100; i <= floor * 100; i+=100) {
			for(int j = 1; j <= room; j++) {
				ResidentDTO resi = new ResidentDTO();
				resi.getBuild().setBuildId(buildId);
				resi.setUsers(null);
				resi.setEntered(1);
				resi.setResidentNum(i + j);
				residentDTOList.add(resi);
			}
		}
		
		List<Resident> residentList = residentDTOList.stream().map(r -> modelMapper.map(r, Resident.class)).toList();
		
		residentRepository.saveAll(residentList);
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
