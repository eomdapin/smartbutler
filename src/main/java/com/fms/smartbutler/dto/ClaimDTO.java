package com.fms.smartbutler.dto;

/**
* @author 송창민
* @editDate 2024-01-27 ~ 2024-01-28
*/

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
	private String buildName;
	
	public ClaimDTO() {
		status = 1;
	}
}
