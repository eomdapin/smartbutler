package com.fms.smartbutler.repository;

/**
* @author 송창민
* @editDate 2024-01-26 ~ 2024-01-27
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
	
}
