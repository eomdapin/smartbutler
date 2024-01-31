package com.fms.smartbutler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
	private Long companyId;
	private Long buildId;
	private String kindType;
	private String password;
	private String companyName;
	private String manager;
	private String phone;
	private String fromDate;
	private String toDate;
	private Long cost;
	private String role;
}
