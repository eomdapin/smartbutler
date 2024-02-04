package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-01-25 ~ 2024-01-29
*/

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user/buildings")
@RequiredArgsConstructor
public class UserBuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 건물 정보
	@GetMapping("/build")
	public ResponseEntity<List<BuildDTO>> getBuilds(@RequestParam(required = false) Long buildId) {
		List<BuildDTO> builds = buildService.findAll();
		
		return ResponseEntity.status(200).body(builds);
	}
	
	@GetMapping("/images")
	public ResponseEntity<List<ImageDTO>> getBuildImages(@RequestParam(required = false) Long buildId) {
		buildId = buildId == null ? 1 :buildId;
		List<ImageDTO> images = imageService.findByOutIdAndCoded(buildId, "b");
		
		return ResponseEntity.status(200).body(images);
	}
}
