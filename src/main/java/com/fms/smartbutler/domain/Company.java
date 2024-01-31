package com.fms.smartbutler.domain;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyId;

	@Column(name = "build_id")
	private Long buildId;

	@Column(name = "kind_type")
	private String kindType;

	@Column(name = "pw")
	private String password;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "manager")
	private String manager;

	@Column(name = "phone")
	private String phone;

	@Column(name = "from_date")
	private String fromDate;

	@Column(name = "to_date")
	private String toDate;

	@Column(name = "cost")
	private Long cost;
	
	@Column(name = "role")
	private String role;
	
	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.password = "{noop}" + this.password;
	}
}
