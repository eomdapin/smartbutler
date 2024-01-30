package com.fms.smartbutler.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {
	
	private Long jobId;
	private Long buildId;
	private Long companyId;
	private Long itemId;
	private String title;
	private String content;
	private String reportContent;
	private Date askDate;
	private Date finDate;
	private int status;
}
