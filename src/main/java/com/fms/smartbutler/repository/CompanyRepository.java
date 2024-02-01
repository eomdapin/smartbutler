package com.fms.smartbutler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Company findByCompanyName(String companyName);
	
	@SuppressWarnings("unchecked")
	Company save(Company company);
	
	Optional<Company> findById(Long companyId);
	
//	List<Company> findAll();
	
	void deleteById(Long companyId);
	
}
