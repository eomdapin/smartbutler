package com.fms.smartbutler.dto;

import java.sql.Date;

import com.fms.smartbutler.domain.Claim;

import lombok.Data;

@Data
public class ClaimDTO {
	
	private Long claimId;
	private Long buildId;
	private Long userId;
	private String title;
	private String claimKind;
	private Date askDate;
	private Date finDate;
	
	public ClaimDTO(Claim claim) {
		this.claimId = claim.getClaimId();
		this.buildId = claim.getBuild().getBuildId();
		this.userId = claim.getUser().getUserId();
		this.title = claim.getTitle();
		this.claimKind = claim.getClaimKind();
		this.askDate = claim.getAskDate();
		this.finDate = claim.getFinDate();
	}
}
