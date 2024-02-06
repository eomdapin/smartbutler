package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-01-25 ~ 2024-01-29
*/

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ImageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/buildings")
@RequiredArgsConstructor
public class UserBuildController {
	
	private final BuildService buildService;
	private final ImageService imageService;
	
	// 건물 정보
	@GetMapping("/build")
	public ResponseEntity<List<Object>> getBuilds(@RequestParam(required = false) Long buildId) {
		buildId = buildId == null ? 1 :buildId;
		List<BuildDTO> builds = buildService.findAll();
		List<ImageDTO> images = imageService.findByOutIdAndCoded(buildId, "b");
		
		List<Object> content = new ArrayList<>();
		content.add(builds);
		content.add(images);
		content.add(buildId);
		
		return ResponseEntity.status(200).body(content);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/image")
	public ResponseEntity<?> getImages(@RequestParam(required = false) String image) {
		String filePath = "";
		String os = System.getProperty("os.name").toLowerCase();
		
		if(os.contains("win")) {
			filePath = "C:\\web-img\\";
		} else {
			filePath = "home/ec2-user/web-img/";
		}
		Resource resource = new FileSystemResource(filePath + image);
		
		return new ResponseEntity<>(resource, HttpStatus.OK); 
	}
}