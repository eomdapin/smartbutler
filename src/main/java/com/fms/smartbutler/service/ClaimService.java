package com.fms.smartbutler.service;

/**
 * @author 송창민
 * @editDate 2024-01-26 ~ 2024-01-29
 */

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fms.smartbutler.domain.Claim;
import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.repository.ClaimRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
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
		claimDTO.setClaimId(claim.getClaimId());
	}
	
	public Optional<ClaimDTO> findById(Long claimId) {
		Optional<Claim> claim = claimRepository.findById(claimId);
		ClaimDTO claimDTO = modelMapper.map(claim, ClaimDTO.class);
		
		return Optional.ofNullable(claimDTO);
	}
	
	public void finishClaim(ClaimDTO claimDTO) {
		claimDTO.setFinDate(Date.valueOf(LocalDate.now()));
		claimDTO.setStatus(2);
		
		Claim claim = modelMapper.map(claimDTO, Claim.class);
		
		claimRepository.save(claim);
	}
	
	public void delete(ClaimDTO claimDTO) {
		Claim claim = modelMapper.map(claimDTO, Claim.class);
		
		claimRepository.delete(claim);
	}
	
	public Page<ClaimDTO> findByBuildId(Long buildId, Pageable pageable) {
		Page<Claim> claimList;
		
		if(buildId == 0) {
			claimList = claimRepository.findAllByOrderByClaimIdDesc(pageable);
		} else {
			claimList = claimRepository.findByBuild_BuildIdOrderByClaimIdDesc(buildId, pageable);
		}
		
		Page<ClaimDTO> claimDTOList = claimList.map(c -> modelMapper.map(c, ClaimDTO.class));
		
		return claimDTOList;
	}
	
	public Page<ClaimDTO> findByUserId(Long userId, Pageable pageable) {
		Page<Claim> claimList = claimRepository.findByUser_UserIdOrderByClaimIdDesc(userId, pageable);;
		Page<ClaimDTO> claimDTOList = claimList.map(c -> modelMapper.map(c, ClaimDTO.class));
		
		return claimDTOList;
	}
}
