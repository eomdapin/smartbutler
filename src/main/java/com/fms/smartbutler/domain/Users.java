package com.fms.smartbutler.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
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
	
//	@OneToMany(mappedBy = "users")
//	private List<Estimate> estimates = new ArrayList<>();
//	
//	@OneToMany(mappedBy = "users")
//	private List<Resident> residents = new ArrayList<>();
	
	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.pw = passwordEncoder.encode(this.pw);
	}

}
