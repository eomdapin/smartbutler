package com.fms.smartbutler.formdto;

/**
* @author 송창민
* @editDate 2024-02-13 ~ 2024-02-13 
*/

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class JobFormDTO {
	
	private Long jobId;
	private Long buildId;
	private Long companyId;
	private Long itemId;
	
	@NotBlank(message = "제목을 입력해주세요.")
	private String title;
	
	@NotBlank(message = "내용을 입력해주세요.")
	private String content;
	
	private String reportContent;
	
	@NotNull
	private Date askDate;
	
	private Date finDate;
	private int status;
	private String itemName;
	private String companyName;
	private String companyManager;
	private String buildName;
	
	public JobFormDTO() {
		this.status = 1;
	}
}
