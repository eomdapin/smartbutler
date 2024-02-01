package com.fms.smartbutler.domain;

import java.time.LocalDate;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "cost")
public class Cost {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cost_id")
	private Long costId;
	
	@ManyToOne
	@JoinColumn(name = "build_id")
	private Build build;
	
	@Column(name = "cost_date")
	private LocalDate date;
	
	@Column(name = "electricity")
	private Long electricity;
	
	@Column(name = "repair")
	private Long repair;
	
	@Column(name = "upkeep")
	private Long upkeep;
	
	@Column(name = "consignment")
	private Long consignment;
	
	@Column(name = "send")
	private Integer send;
}
