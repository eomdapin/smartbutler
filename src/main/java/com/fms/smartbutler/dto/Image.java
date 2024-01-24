package com.fms.smartbutler.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long imageId;
	private String name;
	private String realName;
	private String src;
	private String realSrc;
}
