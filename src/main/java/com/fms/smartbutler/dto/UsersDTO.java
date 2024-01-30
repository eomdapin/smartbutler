package com.fms.smartbutler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDTO {
	
	private Long userId;
	private String name;
	private String phone;
	private String email;
	private int status;
	private String pw;
}
