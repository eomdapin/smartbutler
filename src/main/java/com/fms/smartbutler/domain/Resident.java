package com.fms.smartbutler.domain;

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
@Table(name = "resident")
public class Resident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long residentId;
	
	@ManyToOne
    @JoinColumn(name="build_id")
	private Build build;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "from_date")
	private String fromDate;
	
	@Column(name = "to_date")
	private String toDate;
	
	@Column(name = "deposit")
	private Long deposit;
	
	@Column(name = "monthly")
	private Long monthly;
}
