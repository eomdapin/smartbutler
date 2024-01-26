package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
//	List<Claim> findByIdAndBuild_BuildId(Long claimId, Long buildId);
}
