package com.fms.smartbutler.service;

import org.springframework.stereotype.Service;

import com.fms.smartbutler.dto.Claim;
import com.fms.smartbutler.repository.ClaimRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaimService {

	private final ClaimRepository claimRepository;
	
	public void saveClaim(Claim claim) {
		claimRepository.save(claim);
	}
}
