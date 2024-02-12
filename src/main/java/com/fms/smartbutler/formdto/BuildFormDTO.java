package com.fms.smartbutler.formdto;

/**
* @author 엄다빈
* @editDate 2024-02-12 ~ 2024-02-12 
*/

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class BuildFormDTO {
	
	private Long buildId;
	
	@NotBlank(message = "건물명을 입력해주세요.")
	private String buildName;
	
	@NotBlank(message = "주소를 입력해주세요.")
	private String address;
	
	@NotNull(message="숫자만 입력해주세요.")
	@Range(min = 1, max = 99, message = "숫자 범위를 초과했습니다.")
	private Integer floor;
	
	@NotNull(message="숫자만 입력해주세요.")
	@Range(min = 1, max = 99, message = "숫자 범위를 초과했습니다.")
	private Integer room;
	
	@NotNull(message="숫자만 입력해주세요.")
	private Integer area;
	
	@NotBlank
	private String comDate;
}
