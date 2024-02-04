package com.fms.smartbutler.domain;

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
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "resident")
public class Resident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resident_id")
	private Long residentId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "build_id")
	private Build build;
	
	@Column(name = "resident_num")
	private Long residentNum;
	
	@Column(name = "entered")
	private int entered;
	
	@Column(name = "from_date")
	private String fromDate;
	
	@Column(name = "to_date")
	private String toDate;
	
	@Column(name = "deposit")
	private Long deposit;
	
	@Column(name = "monthly")
	private Long monthly;
}
