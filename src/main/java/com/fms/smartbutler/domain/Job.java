package com.fms.smartbutler.domain;

import java.sql.Date;

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
public class Job {
	
	@Id
	@GeneratedValue
	private Long workId;
	private Long buildId;
	private Long itemId;
	private Long companyId;
//	private String kindType;
	private String title;
	private Date askDate;
	private String content;
	private Date finDate;
	private int status;
	private Long imgId;
	private String reportContent;
	private Long reportImgId;
}
