package com.fms.smartbutler.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class ClaimDTO {
	
	private Long claimId;
	private Long buildId;
	private Long userId;
	private String title;
	private String claimKind;
	private String content;
	private Date askDate;
	private Date finDate;
	private int status;
	
	public ClaimDTO() {
		status = 1;
	}
}
