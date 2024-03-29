package com.fms.smartbutler.domain;

/**
 * @author 전종배
 * @since 2024-02-01 to 2024-02-03
 */

import java.sql.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "build_id")
	private Build build;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kind_type")
	private CompanyKind companyKind;

	@Column(name = "pw")
	private String password;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "manager")
	private String manager;

	@Column(name = "phone")
	private String phone;

	@Column(name = "from_date")
	private Date fromDate;

	@Column(name = "to_date")
	private Date toDate;

	@Column(name = "cost")
	private Long cost;

	@Column(name = "role")
	private String role;

	@Entity
	@Setter @Getter
	@AllArgsConstructor @NoArgsConstructor
	@Table(name = "company_kind")
	public static class CompanyKind {

		@Id
		@Column(name = "kind_type")
		private Long kindType;
		
		@Column(name = "kind_name")
		private String kindName;
	}

	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(this.password);
	}
}
