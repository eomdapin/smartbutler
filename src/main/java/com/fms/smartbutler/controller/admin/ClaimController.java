package com.fms.smartbutler.controller.admin;

/**
 * @author 송창민
 * @editDate 2024-01-29 ~ 2024-01-30
 */

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.service.ClaimService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class ClaimController {
	
	private final ClaimService claimService;
	private final ImageService imageService;
	
	// 민원 목록
	@GetMapping("/{buildId}/claims")
	public String getClaimList(@PathVariable Long buildId, Model model) {
		List<ClaimDTO> claims = claimService.findAll();
		
		model.addAttribute("claims", claims);
		
		return "admin/claim/claim-list";
	}
	
	// 민원 상세
	@GetMapping("/{buildId}/claims/{claimId}")
	public String getClaimInfo(@PathVariable("buildId") Long buildId, @PathVariable("claimId") Long claimId, Model model) {
		ClaimDTO claimDTO = claimService.findById(claimId).orElseGet(ClaimDTO::new);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(claimDTO.getClaimId(), "c");
		FileVo vo = new FileVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("claim", claimDTO);
		model.addAttribute("images", images);
		model.addAttribute("vo", vo);
		
		return "admin/claim/claim-info";
	}
	
	// 민원 처리
	@PostMapping("/{buildId}/claims/{claimId}")
	public String postClaimInfo(@ModelAttribute ClaimDTO claimDTO) {
		claimService.finishClaim(claimDTO);
		
		return "redirect:/admin/buildings/{buildId}/claims";
	}
}
