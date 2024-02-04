package com.fms.smartbutler.domain;

/**
* @author 엄다빈
* @editDate 2024-01-23 ~ 2024-01-24
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "build")
public class Build {
	
	@Id
	@Column(name = "build_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long buildId;
	
	@Column(name = "build_name")
	private String buildName;

	@Column(name = "address")
	private String address;
	
	@Column(name = "floor")
	private Integer floor;
	
	@Column(name = "room")
	private Integer room;
	
	@Column(name = "area")
	private Integer area;
	
	@Column(name = "com_date")
	private String comDate;
}
