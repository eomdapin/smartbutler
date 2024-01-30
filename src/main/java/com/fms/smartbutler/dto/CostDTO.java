package com.fms.smartbutler.dto;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CostDTO {
	private Long costId;
	private Long buildId;
	private String date;
	private Long electricity;
	private Long repair;
	private Long upkeep;
	private Long consignment;
	private Integer send;
	private String buildName;
}
