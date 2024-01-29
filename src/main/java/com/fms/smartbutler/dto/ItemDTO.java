package com.fms.smartbutler.dto;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor 
@NoArgsConstructor
public class ItemDTO {
	
	private Long itemId;
	private Long buildId;
	private String kindType;
	private String itemName;
	private String location;
	private Date fromDate;
	private int status;
	private Date checkDate;
	private int checkCycle;
	private String buildName;
	private String kindName;
	
}
