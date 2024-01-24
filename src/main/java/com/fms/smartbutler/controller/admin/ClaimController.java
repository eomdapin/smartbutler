package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClaimController {
	
	@GetMapping("/admin/{buildId}/claim/list")
	public String getClaimList() {
		return "admin/claim/claim-list";
	}
	
	@GetMapping("/admin/{buildId}/claim/list/{claimId}")
	public String getClaimInfo() {
		return "admin/claim/claim-info";
	}
}
