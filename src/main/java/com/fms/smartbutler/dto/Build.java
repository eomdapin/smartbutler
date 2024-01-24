package com.fms.smartbutler.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Build {
	
	@Id
	@GeneratedValue
	private Long buildId;
	private String name;
	private String address;
	private Integer floor;
	private Integer room;
	private String imgId;
	private Integer area;
	private String comDate;
}