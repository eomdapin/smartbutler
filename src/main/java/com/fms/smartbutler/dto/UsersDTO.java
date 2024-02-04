package com.fms.smartbutler.dto;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class UsersDTO {
	
	private Long userId;
	private String userName;
	private String phone;
	private String email;
	private int status;
	private String pw;
	private String role;
	
}
