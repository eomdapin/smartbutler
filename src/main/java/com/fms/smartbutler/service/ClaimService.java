package com.fms.smartbutler.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Claim;
import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.repository.ClaimRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClaimService {

	private final ClaimRepository claimRepository;
	private final ModelMapper modelMapper;
	
	public void insert(ClaimDTO claimDTO) {
		Claim claim = modelMapper.map(claimDTO, Claim.class);
		
		claimRepository.save(claim);
		claimDTO.setClaimId(claim.getClaimId());
	}
	
	public void update(ClaimDTO claimDTO) {
		Claim claim = modelMapper.map(claimDTO, Claim.class);
		
		claimRepository.save(claim);
	}
	
	public Optional<ClaimDTO> findById(Long claimId) {
		Optional<Claim> claim = claimRepository.findById(claimId);
		ClaimDTO claimDTO = modelMapper.map(claim, ClaimDTO.class);
		
		return Optional.ofNullable(claimDTO);
	}
	
	public List<ClaimDTO> findAll() {
		List<Claim> claimList = claimRepository.findAll();
		List<ClaimDTO> claimDTOList = claimList
										.stream()
										.map(c -> 
											modelMapper
											.map(c, ClaimDTO.class))
											.collect(Collectors.toList());
		
		return claimDTOList;
	}
}
