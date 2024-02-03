package com.fms.smartbutler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Company.CompanyKind;

/**
 * @author 전종배
 * @since 2024-02-01 to 2024-02-03
 */

public interface CompanyKindRepository extends JpaRepository<CompanyKind, Long> {

}
