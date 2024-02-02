package com.fms.smartbutler.controller.user;

import java.security.Principal;

/**
* @author 송창민
* @editDate 2024-01-26 ~ 2024-01-29
*/

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.dto.ImageDTO;
import com.fms.smartbutler.dto.UsersDTO;
import com.fms.smartbutler.service.ClaimService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.service.UsersService;
import com.fms.smartbutler.vo.FileVo;
import com.fms.smartbutler.vo.OptionVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user/claims")
@RequiredArgsConstructor
public class UserClaimController {

	private final ClaimService claimService;
	private final ImageService imageService;
	private final UsersService usersService;

	// 민원 목록
	@GetMapping
	public String getClaimList(@RequestParam(defaultValue = "0") int page, Principal principal, Model model) {
		Pageable pageable = PageRequest.of(page, 10, Sort.by("claimId").descending());
		UsersDTO user = usersService.findByEmail(principal.getName()).orElseGet(UsersDTO::new);
		Page<ClaimDTO> claims = claimService.findByUserId(user.getUserId(), pageable);
		
		model.addAttribute("list", claims);
		
		return "user/claim/claim-list";
	}
	
	// 민원 상세
	@GetMapping("/{claimId}")
	public String getClaimInfo(@PathVariable Long claimId, Model model) {
		ClaimDTO claimDTO = claimService.findById(claimId).orElseGet(ClaimDTO::new);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(claimDTO.getClaimId(), "c");
		FileVo vo = new FileVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("claim", claimDTO);
		model.addAttribute("images", images);
		model.addAttribute("vo", vo);
		
		return "user/claim/claim-info";
	}
	
	// 민원 등록 폼
	@GetMapping("/add")
	public String getClaimAdd(Principal principal, Model model) {
		UsersDTO user = usersService.findByEmail(principal.getName()).orElseGet(UsersDTO::new);
		OptionVo options = new OptionVo();
		
		model.addAttribute("user", user);
		model.addAttribute("options", options.getOptions());
		
		return "user/claim/claim-add";
	}
	
	// 민원 등록
	@PostMapping("/add")
	public String postClaimAdd(@ModelAttribute ClaimDTO claimDTO, @ModelAttribute FileVo vo) throws Exception {
		claimService.insert(claimDTO);
		
		if(!vo.getFileName().isEmpty()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setCoded("c");
			imageService.saveImage(vo, imageDTO, claimDTO.getClaimId());
		}
		
		return "redirect:/user/claims";
	}
	
	// 민원 수정 폼
	@GetMapping("/{claimId}/edit")
	public String getClaimEdit(@PathVariable Long claimId, Model model) {
		ClaimDTO claimDTO = claimService.findById(claimId).orElseGet(ClaimDTO::new);
		List<ImageDTO> images = imageService.findByOutIdAndCoded(claimDTO.getClaimId(), "c");
		FileVo vo = new FileVo();
		OptionVo options = new OptionVo();
		
		if(images.size() > 0) {
			vo.setFileName(images.get(0).getRealName());
		}
		
		model.addAttribute("claim", claimDTO);
		model.addAttribute("vo", vo);
		model.addAttribute("options", options.getOptions());
		
		return "user/claim/claim-edit";
	}
	
	// 민원 수정
	@PutMapping("/{claimId}/edit")
	public String putClaimEdit(@ModelAttribute ClaimDTO claimDTO, @ModelAttribute FileVo vo) throws Exception {
		claimService.update(claimDTO);
		log.info("vo.geFileName = " + vo.getFileName());
		
		if(vo.getFileName() != null && !vo.getFileName().isEmpty()) {
			ImageDTO imageDTO = new ImageDTO();
			imageDTO.setCoded("c");
			imageService.saveImage(vo, imageDTO, claimDTO.getClaimId());
		}
		
		return "redirect:/user/claims";
	}
	
	// 민원 삭제
	@DeleteMapping("/{claimId}")
	public String deleteClaim(@ModelAttribute ClaimDTO claimDTO) {
		claimService.delete(claimDTO);
		
		return "redirect:/user/claims";
	}
}
