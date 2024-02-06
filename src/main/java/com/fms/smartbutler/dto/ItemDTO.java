package com.fms.smartbutler.dto;

/**
* @author 정시운
* @editDate 2024-01-29 ~ 2024-01-31
*/

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ItemDTO {
	
	private Long itemId;
	private Long buildId;
	private String kindType;
	private String itemName;
	private String location;
	private Date fromDate;
	private int status;
	private Date checkDate;
	private String checkCycle;
	private String buildName;
	private String kindName;
	
	@Setter @Getter
	@AllArgsConstructor @NoArgsConstructor
	public static class ItemKindDTO {
		
		private String kindType;
		private String kindName;
	}
}
