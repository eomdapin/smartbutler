package com.fms.smartbutler.service;

import java.io.File;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fms.smartbutler.domain.Image;
import com.fms.smartbutler.repository.ImageRepository;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {
	
	private final ImageRepository imageRepository;
	
	private Image uploadImage(FileVo vo, Image image, Long outId, String code) throws Exception {
		MultipartFile file = vo.getUploadFile();
		
		if(!file.isEmpty()) {
			String originalFileName = file.getOriginalFilename();
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\web-img\\";
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + originalFileName;
			
			file.transferTo(new File(filePath + fileName));
			image.setName(fileName);
//			image.setCode(code);
			image.setOutId(outId);
			image.setRealName(originalFileName);
			image.setSrc(filePath);
			image.setRealSrc(filePath);
		}
			return image;
	}
	
	
	public void saveImage(FileVo vo, Image image, Long outId, String code) throws Exception {
		uploadImage(vo, image, outId, code);
		imageRepository.save(image);
	}
	
	public void deleteImage(Image image) {
		File delFile = new File(image.getSrc() + image.getName());
		if(delFile.exists()) {
			delFile.delete();
			imageRepository.delete(image);
		}
	}
	
	public Optional<Image> findById(Long imgId) {
		return imageRepository.findById(imgId);
	}
}
