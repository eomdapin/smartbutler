package com.fms.smartbutler.dto;

import java.sql.Date;

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
	private Date fromDate;
	private Date toDate;
	private Long cost;
	private String role;
	private String kindName;

	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyKindDTO {

		private String kindType;
		private String kindName;
	}
}
