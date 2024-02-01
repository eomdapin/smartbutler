package com.fms.smartbutler.dto;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class EstimateDTO {
	
	private Long estimateId;
	private Long buildId;
	private Long userId;
	private Long deposit;
	private String period;
	private String regDate;
	private Date toDate;
	private int confirm;
	private String content;
	private String buildName;
	private String userName;
	
	public EstimateDTO() {
		
		LocalDateTime time = LocalDateTime.now();
		
		regDate = time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
}
