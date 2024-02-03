package com.fms.smartbutler.domain;

/**
 * @author 송창민
 * @editDate 2024-01-31 ~ 2024-01-31
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
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Job {
	
	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "build_id")
	private Build build;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "report_content")
	private String reportContent;
	
	@Column(name = "ask_date")
	private Date askDate;
	
	@Column(name = "fin_date")
	private Date finDate;
	
	@Column(name = "status")
	private int status;
}
