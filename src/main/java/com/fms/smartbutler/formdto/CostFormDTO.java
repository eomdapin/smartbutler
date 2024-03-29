package com.fms.smartbutler.formdto;

/**
* @author 엄다빈
* @editDate 2024-02-12 ~ 2024-02-12 
*/

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class CostFormDTO {
	
	private Long costId;
	private Long buildId;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	@Range(min = 1, message = "1이상의 숫자를 입력해주세요.")
	private Long electricity;
	
	@NotNull
	@Range(min = 1, message = "1이상의 숫자를 입력해주세요.")
	private Long repair;
	
	@NotNull
	@Range(min = 1, message = "1이상의 숫자를 입력해주세요.")
	private Long upkeep;
	
	@NotNull
	@Range(min = 1, message = "1이상의 숫자를 입력해주세요.")
	private Long consignment;
	
	private Integer send;
	private String buildName;
	private Integer residentCnt;
}
