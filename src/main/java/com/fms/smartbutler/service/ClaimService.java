package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Claim;
import com.fms.smartbutler.repository.ClaimRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaimService {

	private final ClaimRepository claimRepository;
	
	public void insert(Claim claim) {
		claimRepository.save(claim);
	}
	
	public void update(Claim claim) {
		claimRepository.save(claim);
	}
	
	public Optional<Claim> findById(Long claimId) {
		return claimRepository.findById(claimId);
	}
	
	public List<Claim> findAll() {
		return claimRepository.findAll();
	}
}
