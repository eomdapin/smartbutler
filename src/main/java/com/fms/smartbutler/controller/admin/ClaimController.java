package com.fms.smartbutler.controller.admin;

/**
 * @author 송창민
 * @editDate 2024-01-29 ~ 2024-01-30
 */

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.service.BuildService;
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
	private final BuildService buildService;
	
	// 민원 목록
	@GetMapping("/{buildId}/claims")
	public String getClaimList(@PathVariable Long buildId, @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size, Model model) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("claimId").descending());
		List<BuildDTO> builds = buildService.findAll();
		BuildDTO build = buildService.findById(buildId);
		Page<ClaimDTO> claims = claimService.findByBuildId(buildId, pageable);

		model.addAttribute("list", claims);
		model.addAttribute("builds", builds);
		model.addAttribute("build", build);
		model.addAttribute("buildId", (buildId == 0 || buildId == null) ? 0L : buildId);
		
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
		
		return "redirect:/admin/buildings/0/claims";
	}
}
