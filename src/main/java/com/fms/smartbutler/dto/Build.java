package com.fms.smartbutler.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long buildId;
	private String buildName;
	private String address;
	private Integer floor;
	private Integer room;
	private Long imgId;
	private Integer area;
	private String comDate;
}
