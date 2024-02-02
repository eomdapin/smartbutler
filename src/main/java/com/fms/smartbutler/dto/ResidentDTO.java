package com.fms.smartbutler.dto;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ResidentDTO {
	
	private Long residentId;
	private Long buildId;
	private String buildName;
	private Long userId;
	private String userName;
	private Long residentNum;
	private String phone;
	private int entered;
	private String fromDate;
	private String toDate;
	private Long deposit;
	private Long monthly;
	private Users users = new Users();
	private Build build = new Build();
}
