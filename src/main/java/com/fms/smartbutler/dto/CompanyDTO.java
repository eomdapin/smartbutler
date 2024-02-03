package com.fms.smartbutler.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 전종배
 * @since 2024-02-01 to 2024-02-03
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {
	private Long companyId;
	private Long buildId;
	private Long kindType;
	private String password;
	private String companyName;
	private String manager;
	private String phone;
	private Date fromDate;
	private Date toDate;
	private Long cost;
	private String role;
	private String kindName;
	private String buildName;

	/**
	 * @author 전종배 assisted by 엄다빈(팀장)
	 * @since 2024-02-01 to 2024-02-03
	 */
	
	@Setter
	@Getter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CompanyKindDTO {

		private Long kindType;
		private String kindName;
	}
}
