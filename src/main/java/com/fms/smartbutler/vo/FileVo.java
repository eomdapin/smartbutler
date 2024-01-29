package com.fms.smartbutler.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
* @author 엄다빈
* @editDate 2024-01-24 ~ 2024-01-25
*/

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class FileVo {
	private String fileName;
	private MultipartFile uploadFile;
}
