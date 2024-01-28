package com.fms.smartbutler.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Image;
import com.fms.smartbutler.dto.ClaimDTO;
import com.fms.smartbutler.service.ClaimService;
import com.fms.smartbutler.service.ImageService;
import com.fms.smartbutler.vo.FileVo;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/claims")
@RequiredArgsConstructor
public class UserClaimController {

		private final ClaimService claimService;
		private final ImageService imageService;

		// 민원 목록
		@GetMapping
		public String getClaimList(Model model) {
			List<ClaimDTO> claims = claimService.findAll();
			
			model.addAttribute("claims", claims);
			
			return "user/claim/claim-list";
		}
		
		// 민원 상세
		@GetMapping("/{claimId}")
		public String getClaimInfo(@PathVariable Long claimId, Model model) {
			ClaimDTO claimDTO = claimService.findById(claimId).orElseGet(ClaimDTO::new);
			List<Image> images = imageService.findByOutIdAndCoded(claimDTO.getClaimId(), "c");
			FileVo vo = new FileVo();
			
			if(images.size() > 0) {
				vo.setFileName(images.get(0).getRealName());
			}
			
			model.addAttribute("claim", claimDTO);
			model.addAttribute("vo", vo);
			
			return "user/claim/claim-info";
		}
		
		// 민원 등록 폼
		@GetMapping("/add")
		public String getClaimAdd(Model model) {
			List<String> options = new ArrayList<String>();
			
			options.add("전기");
			options.add("수도");
			options.add("냉난방기");
			options.add("엘리베이터");
			options.add("기타");
			
			model.addAttribute("options", options);
			
			return "user/claim/claim-add";
		}
		
		// 민원 등록
		@PostMapping("/add")
		public String postClaimAdd(@ModelAttribute ClaimDTO claimDTO, @ModelAttribute FileVo vo) throws Exception {
			claimService.insert(claimDTO);
			
			if(!vo.getFileName().isEmpty()) {
				Image image = new Image();
				image.getImageCategory().setCoded("c");
				imageService.saveImage(vo, image, claimDTO.getClaimId());
			}
			
			return "redirect:/user/claims";
		}
}
