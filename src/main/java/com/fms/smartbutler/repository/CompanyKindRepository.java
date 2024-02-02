package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Company.CompanyKind;

public interface CompanyKindRepository extends JpaRepository<CompanyKind, Long> {

}
