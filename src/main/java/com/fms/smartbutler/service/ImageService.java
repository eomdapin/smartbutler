package com.fms.smartbutler.service;

/**
* @author 엄다빈
* @editDate 2024-01-24 ~ 2024-01-25
*/

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fms.smartbutler.domain.Image;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.repository.ImageRepository;
import com.fms.smartbutler.vo.FileVo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageService {
	
	private final ImageRepository imageRepository;
	private final ModelMapper modelMapper;
	
	private ImageDTO uploadImage(FileVo vo, ImageDTO imageDTO, Long outId) throws Exception {
		MultipartFile file = vo.getUploadFile();
		
		if(!file.isEmpty()) {
			String originalFileName = file.getOriginalFilename();
			String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\web-img\\";
			UUID uuid = UUID.randomUUID();
			String fileName = uuid + originalFileName;
			
			file.transferTo(new File(filePath + fileName));
			imageDTO.setName(fileName);
			imageDTO.setOutId(outId);
			imageDTO.setRealName(originalFileName);
			imageDTO.setSrc(filePath);
			imageDTO.setRealSrc(filePath);
		}
		
		return imageDTO;
	}
	
	public void saveImage(FileVo vo, ImageDTO imageDTO, Long outId) throws Exception {
		uploadImage(vo, imageDTO, outId);

		if(imageDTO.getName() != null) {
			Image image = modelMapper.map(imageDTO, Image.class);
			image.getImageCategory().setCoded(imageDTO.getCoded());
			imageRepository.save(image);
		}
	}
	
	public void deleteImage(ImageDTO imageDTO) {
		File delFile = new File(imageDTO.getSrc() + imageDTO.getName());
		
		if(delFile.exists()) {
			delFile.delete();
			Image image = modelMapper.map(imageDTO, Image.class);
			imageRepository.delete(image);
		}
	}
	
	public ImageDTO findById(Long imgId) {
		Image image = imageRepository.findById(imgId).orElseGet(Image::new);
		
		return modelMapper.map(image, ImageDTO.class); 
	}
	
	public List<ImageDTO> findByOutIdAndCoded(Long outId, String coded) {
		return imageRepository.findByOutIdAndImageCategory_Coded(outId, coded).stream()
				.map(image -> modelMapper.map(image, ImageDTO.class)).toList();
	}
}
