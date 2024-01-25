package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import com.fms.smartbutler.domain.Claim;

public interface ClaimRepository {
	void save(Claim claim);
	Optional<Claim> findById(Long claimId);
	List<Claim> findAll();
}
