package com.fms.smartbutler.service;

import java.io.File;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fms.smartbutler.dto.Image;
import com.fms.smartbutler.repository.ImageRepository;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	public void saveImage(FileVo vo, Image image) throws Exception {
		MultipartFile file = vo.getUploadFile();
		
		if(!file.isEmpty()) {
			String originalFileName = file.getOriginalFilename();
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\web-img\\";
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + originalFileName;
			file.transferTo(new File(filePath + fileName));
			
			image.setName(fileName);
			image.setRealName(originalFileName);
			image.setSrc(filePath);
			image.setRealSrc(filePath);
			
			imageRepository.save(image);
		}
	}
	
	public Optional<Image> findById(Long imgId) {
		return imageRepository.findById(imgId);
	}
}
