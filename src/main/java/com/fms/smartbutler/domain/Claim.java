package com.fms.smartbutler.domain;

/**
* @author 송창민
* @editDate 2024-01-26 ~ 2024-01-27
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
@Table(name = "claim")
public class Claim {
	
	@Id
	@Column(name = "claim_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "build_id")
	private Build build;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "claim_kind")
	private String claimKind;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "ask_date")
	private Date askDate;
	
	@Column(name = "fin_date")
	private Date finDate;
	
	@Column(name = "status")
	private int status;
}
