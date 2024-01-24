package com.fms.smartbutler.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private Long userId;
	private String name;
	private String phone;
	private String email;
	private Integer status;
	
	@Entity
	@Setter @Getter
	@AllArgsConstructor @NoArgsConstructor
	public static class UserLogin {
		
		@Id
		private Long userId;
		private String pw;
	}
}
