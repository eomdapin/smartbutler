package com.fms.smartbutler.controller.user;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Claim;
import com.fms.smartbutler.service.ClaimService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/claims")
@RequiredArgsConstructor
public class UserClaimController {

		private final ClaimService claimService;

		// 민원 목록
		@GetMapping
		public String getClaimList(Model model) {
			List<Claim> claims = claimService.findAll();
			
			model.addAttribute("claims", claims);
			
			return "user/claim/claim-list";
		}
		
		// 민원 상세
		@GetMapping("/{claimId}")
		public String getClaimInfo(@PathVariable Long claimId, Model model) {
			Claim claim = claimService.findById(claimId).get();
			
			model.addAttribute("claim", claim);
			
			return "user/claim/claim-info";
		}
		
		// 민원 등록 폼
		@GetMapping("/add")
		public String getClaimAdd(Model model) {
			LocalDate localDate = LocalDate.now();
			Date today = Date.valueOf(localDate);
			
			model.addAttribute("today", today);
			
			return "user/claim/claim-add";
		}
		
		// 민원 등록
		@PostMapping("/add")
		public String postClaimAdd(@ModelAttribute Claim claim) {
			claimService.insert(claim);
			
			return "redirect:/user/claims";
		}
}
