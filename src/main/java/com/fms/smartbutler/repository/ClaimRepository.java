package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* @author 송창민
* @editDate 2024-01-26 ~ 2024-01-27
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Page<Claim> findByBuild_BuildIdOrderByClaimIdDesc(Long buildId, Pageable pageable);
	Page<Claim> findAllByOrderByClaimIdDesc(Pageable pageable);
	List<Claim> findAllByStatus(int status);
}
