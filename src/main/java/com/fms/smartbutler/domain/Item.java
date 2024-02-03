package com.fms.smartbutler.domain;

/**
* @author 정시운
* @editDate 2024-01-29 ~ 2024-01-31
*/

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor 
@NoArgsConstructor
public class Item {
	
	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "build_id")
	private Build build;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kind_type")
	private ItemKind itemKind;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "check_date")
	private Date checkDate;
	
	@Column(name = "check_cycle")
	private String checkCycle;
	
	@Entity
	@Getter @Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name = "item_kind")
	public static class ItemKind {
		
		@Id
		@Column(name = "kind_type")
		private String kindType;
		
		@Column(name = "kind_name")
		private String kindName;
		
	}
}
