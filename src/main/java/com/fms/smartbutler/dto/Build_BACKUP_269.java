package com.fms.smartbutler.dto;

import jakarta.persistence.Column;
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
<<<<<<< HEAD
	private String buildName;
=======
	
	@Column(name = "build_name")
	private String buildName;

	@Column(name = "address")
>>>>>>> dapin
	private String address;
	
	@Column(name = "floor")
	private Integer floor;
	
	@Column(name = "room")
	private Integer room;
	
	@Column(name = "imgId")
	private Long imgId;
	
	@Column(name = "area")
	private Integer area;
	
	@Column(name = "com_date")
	private String comDate;
}
