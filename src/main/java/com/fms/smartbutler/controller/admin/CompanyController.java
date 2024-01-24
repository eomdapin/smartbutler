package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {
	
	@GetMapping("/admin/{buildId}/company/list/{companyId}")
	public String companyInfo() {
		return "admin/company/company-info";
	}
	
	@GetMapping("/admin/{buildId}/company/list")
	public String companyList() {
		return "admin/company/company-list";
	}
	
	@GetMapping("/admin/{buildId}/company/list/{companyId}/update")
	public String updateCompanyInfoForm() {
		return "admin/company/update-company-info";
	}
	
	@PostMapping("/admin/{buildId}/company/list/{companyId}/update")
	public String updateCompanyInfo() {
		return "redirect:/admin/{buildId}/company/list";
	}
	
	@PostMapping("/admin/{buildId}/company/list/{companyId}/delete")
	public String deleteCompanyInfo() {
		return "redirect:/admin/{buildId}/company/list";
	}
	
	@GetMapping("/admin/{buildId}/company/list/add")
	public String addcompanyInfoForm() {
		return "admin/company/add-company-info";
	}
	
	@PostMapping("/admin/{buildId}/company/list/{companyId}/add")
	public String addCompanyInfo() {
		return "redirect:/admin/{buildId}/company/list";
	}

}
