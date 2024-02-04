package com.fms.smartbutler.domain;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
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
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="estimate")
public class Estimate {
	
	@Id
	@Column(name = "estimate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long estimateId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "build_id")
	private Build build;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "deposit")
	private Long deposit;
	
	@Column(name = "period")
	private String period;
	
	@Column(name = "reg_date")
	private String regDate;
	
	@Column(name = "to_date")
	private Date toDate;
	
	@Column(name = "confirm")
	private int confirm;
	
	@Column(name = "content")
	private String content;
	
}
