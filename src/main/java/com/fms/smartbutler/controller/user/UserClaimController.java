package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserClaimController {

		// 민원 목록
		@GetMapping("/user/claim/list")
		public String getClaimList() {
			return "user/claim/claim-list";
		}
		
		// 민원 상세
		@GetMapping("/user/claim/list/{claimId}")
		public String getClaimInfo(@PathVariable Long claimId) {
			return "user/claim/claim-info";
		}
		
		// 민원 등록 폼
		@GetMapping("/user/claim/add")
		public String getClaimAdd() {
			return "user/claim/claim-add";
		}
		
		// 민원 등록
		@PostMapping("/user/claim/add")
		public String postClaimAdd() {
			return "redirect:/user/claim/list";
		}
}
