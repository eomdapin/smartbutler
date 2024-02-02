package com.fms.smartbutler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
public class UsersDTO {
	
	private Long userId;
	private String userName;
	private String phone;
	private String email;
	private int status;
	private String pw;
	private String role;
	
	public UsersDTO() {
		status = 1;
	}
}
