package com.fms.smartbutler.domain;

/**
* @author 정시운
* @editDate 2024-01-24 ~ 2024-01-26
*/

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "phone", unique = true)
	private String phone;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "pw")
	private String pw;
	
	@Column(name = "role")
	private String role;
	
	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.pw = passwordEncoder.encode(this.pw);
	}

}
