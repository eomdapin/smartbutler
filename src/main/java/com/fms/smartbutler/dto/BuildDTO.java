package com.fms.smartbutler.dto;

/**
* @author 엄다빈
* @editDate 2024-01-29 ~ 2024-01-29
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class BuildDTO {
	
	private Long buildId;
	private String buildName;
	private String address;
	private Integer floor;
	private Integer room;
	private Integer area;
	private String comDate;
}
