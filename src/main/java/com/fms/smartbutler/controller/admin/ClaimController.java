package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClaimController {
	
	@GetMapping("/admin/{buildId}/claim/list")
	public String getClaimList(@PathVariable Long buildId) {
		return "admin/claim/claim-list";
	}
	
	@GetMapping("/admin/{buildId}/claim/list/{claimId}")
	public String getClaimInfo(@PathVariable("buildId") Long buildId, @PathVariable("claimId") Long claimId) {
		return "admin/claim/claim-info";
	}
	
	@PostMapping("/admin/{buildId}/claim/list/{claimId}")
	public String postClaimInfo(@PathVariable("buildId") Long buildId, @PathVariable("claimId") Long claimId) {
		return "redirect:/admin/" + buildId + "/claim/list";
	}
}
