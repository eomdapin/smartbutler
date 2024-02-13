package com.fms.smartbutler.formdto;

import org.hibernate.validator.constraints.Range;

/**
* @author 엄다빈
* @editDate 2024-02-12 ~ 2024-02-12 
*/

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.Users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class ResidentFormDTO {
	
	private Long residentId;
	private Long buildId;
	private String buildName;
	private Long userId;
	private String usersName;
	private int entered;
	private String usersPhone;
	private Users users = new Users();
	private Build build = new Build();
	
	@NotNull(message = "세대 번호를 입력해주세요.")
	private int residentNum;
	
	@NotNull(message = "보증금을 입력해주세요.")
	@Range(min = 1, message = "1 이상의 숫자를 입력해주세요.")
	private Long deposit;
	
	@NotNull(message = "월세를 입력해주세요.")
	@Range(min = 1, message = "1 이상의 숫자를 입력해주세요.")
	private Long monthly;
	
	@NotBlank(message = "계약 시작일을 입력해주세요.")
	private String fromDate;
	
	@NotBlank(message = "계약 종료일을 입력해주세요.")
	private String toDate;
}
