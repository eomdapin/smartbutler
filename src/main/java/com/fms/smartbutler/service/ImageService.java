package com.fms.smartbutler.service;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fms.smartbutler.vo.FileVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageService {
	
	public void saveImage(FileVo vo) throws Exception {
		MultipartFile file = vo.getUploadFile();
//		log.info("file.getOriginalFilename() :: {}", file.getOriginalFilename());
		log.info("파일 저장 시작==========================");
		
		if(!file.isEmpty()) {
			String originalFileName = file.getOriginalFilename();
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\web-img\\";
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + originalFileName;
			
			file.transferTo(new File(filePath + fileName));
		}
		log.info("파일 저장 완료!!!");
	}
}
