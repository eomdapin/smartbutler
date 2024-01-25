package com.fms.smartbutler.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fms.smartbutler.domain.Claim;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Transactional
@Repository
@RequiredArgsConstructor
public class ClaimRepositoryJpa implements ClaimRepository {

	private final EntityManager em;
	
	@Override
	public void save(Claim claim) {
		em.persist(claim);
	}

	@Override
	public Optional<Claim> findById(Long claimId) {
		return Optional.empty();
	}

	@Override
	public List<Claim> findAll() {
		return null;
	}
}
