package com.fms.smartbutler.dto;

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
	private String phone;
	private String userName;
	private int status;
	private String fromDate;
	private String toDate;
	private Long deposit;
	private Long monthly;
	private Users users;
}
