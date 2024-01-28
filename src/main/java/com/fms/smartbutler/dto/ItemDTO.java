package com.fms.smartbutler.dto;


import java.sql.Date;

import com.fms.smartbutler.domain.Item;

import lombok.Data;

@Data
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
	
	public ItemDTO(Item item) {
		this.itemId = item.getItemId();
		this.buildId = item.getBuild().getBuildId();
		this.kindType = item.getItemKind().getKindType();
		this.itemName = item.getItemName();
		this.location = item.getLocation();
		this.fromDate = item.getFromDate();
		this.status = item.getStatus();
		this.checkDate = item.getCheckDate();
		this.checkCycle = item.getCheckCycle();
	}

}
