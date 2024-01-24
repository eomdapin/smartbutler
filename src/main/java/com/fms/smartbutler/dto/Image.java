package com.fms.smartbutler.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Image {
	
	@Id
	private Long imageId;
	private String name;
	private String realName;
	private String src;
	private String realSrc;
}
