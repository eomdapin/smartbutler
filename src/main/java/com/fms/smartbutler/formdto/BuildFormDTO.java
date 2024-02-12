package com.fms.smartbutler.formdto;

/**
* @author 엄다빈
* @editDate 2024-02-12 ~ 2024-02-12 
*/

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	
	@NotNull
	@Range(min = 1, max = 99, message = "1부터 99까지의 숫자를 입력해주세요.")
	private Integer floor;
	
	@NotNull
	@Range(min = 1, max = 99, message = "1부터 99까지의 숫자를 입력해주세요.")
	private Integer room;
	
	@NotNull
	private Integer area;
	
	@NotBlank
	@Pattern(regexp = "/^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/", message = "연, 월, 일을 올바르게 입력해주세요.")
	private String comDate;
}
