package com.fms.smartbutler.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	private String name;
	private String phone;
	private String email;
	private Integer status;

	
	@Entity(name = "user_login")
	@Setter @Getter
	@AllArgsConstructor @NoArgsConstructor
	public static class UserLogin {
		
		@Id
		private Long userId;
		private String pw;
	}
}
