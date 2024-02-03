package com.fms.smartbutler.domain;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long id;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	private String role;

	public void encodePassword(PasswordEncoder passwordEncoder) {
//		this.password = "{noop}" + this.password; // 암호화 안함 noop:암호화 규칙 중 하나
		this.password = passwordEncoder.encode(this.password);
	}

}
