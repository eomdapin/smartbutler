package com.fms.smartbutler.repository;

/**
 * @author 전종배
 * @since 2024-02-01 to 2024-02-03
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByCompanyName(String companyName);
}
