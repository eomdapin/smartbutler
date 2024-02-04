package com.fms.smartbutler.repository;

/**
 * @author 송창민
 * @editDate 2024-01-27 ~ 2024-01-28
 */

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
	Page<Claim> findAllByOrderByClaimIdDesc(Pageable pageable);
	Page<Claim> findByBuild_BuildIdOrderByClaimIdDesc(Long buildId, Pageable pageable);
	Page<Claim> findByUser_UserIdOrderByClaimIdDesc(Long userId, Pageable pageable);
	List<Claim> findAllByStatus(int status);
}
