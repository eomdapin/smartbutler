package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByCompanyName(String companyName);
}
