package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-01-23 ~ 2024-01-24
*/

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.repository.BuildRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BuildService {
	
	private final BuildRepository buildRepository;
	private final ModelMapper modelMapper;
	
	public void insert(BuildDTO buildDTO) {
		Build build = modelMapper.map(buildDTO, Build.class);
		buildRepository.save(build);
		buildDTO.setBuildId(build.getBuildId());
	}
	
	public BuildDTO findById(Long buildId) {
		Build build = buildRepository.findById(buildId).orElseGet(Build::new);
		return modelMapper.map(build, BuildDTO.class);
	}
	
	public List<BuildDTO> findAll() {
		return buildRepository.findAll().stream()
				.map(build -> modelMapper.map(build, BuildDTO.class)).toList();
	}
}
