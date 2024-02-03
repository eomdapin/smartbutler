package com.fms.smartbutler.dto;

/**
 * @author 송창민
 * @editDate 2024-01-31 ~ 2024-01-31
 */

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
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
	private String itemName;
	private String companyName;
	private String companyManager;
	private String buildName;
	
	public JobDTO() {
		this.status = 1;
	}
}
