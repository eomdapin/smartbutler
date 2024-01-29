package com.fms.smartbutler.dto;


import java.sql.Date;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.Item.ItemKind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
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
	private String kindName;
	
	private Build build;
	private ItemKind itemKind;
}
