package com.fms.smartbutler.repository;

import java.util.List;

/**
* @author 송창민
* @editDate 2024-01-26 ~ 2024-01-27
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
	List<Claim> findByBuild_BuildId(Long buildId);
}
