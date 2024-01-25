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
public class Claim {
	
	@Id
	@GeneratedValue
	private Long claimId;
	private Long buildId;
	private Long userId;
	private String title;
	private String claimKind;
	private String content;
	private Date askDate;
	private Date finDate;
	private int status;
	private Long imageId;
}
