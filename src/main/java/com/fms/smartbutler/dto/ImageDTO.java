package com.fms.smartbutler.dto;

/**
* @author 엄다빈
* @editDate 2024-01-29 ~ 2024-01-29
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ImageDTO {

	private Long imageId;
	private String coded;
	private Long outId;
	private String name;
	private String realName;
	private String src;
	private String realSrc;
}
