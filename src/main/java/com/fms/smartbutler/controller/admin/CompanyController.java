package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Company;
import com.fms.smartbutler.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/buildings")
public class CompanyController {

	private final CompanyService companyService;

	// 계약 업체 상세
	@GetMapping("/{buildId}/companies/{companyId}")
	public String getCompanyInfo() {
		return "admin/company/company-info";
	}

	// 계약 업체 목록
	@GetMapping("/companies")
	public String getCompanyList(Model model) {
		List<Company> companies = companyService.findAll();
		System.out.println("[p1] companies : " + companies);
		model.addAttribute("companies", companies);
		System.out.println("[p2] model addAttribute");
		return "admin/company/company-info";
	}

	// 계약 업체 수정 폼
	@GetMapping("/companies/{companyId}/update")
	public String getCompanyInfoUpdateForm() {
		return "admin/company/update-company-info";
	}

	// 계약 업체 수정
	@PostMapping("/companies/{companyId}/update")
	public String putCompanyInfo() {
		return "redirect:/admin/{buildId}/company/list";
	}

	// 계약 업체 삭제
	@PostMapping("/companies/{companyId}/delete")
	public String deleteCompanyInfo() {
		return "redirect:/admin/{buildId}/company/list";
	}

	// 계약 업체 등록 폼
	@GetMapping("/companies/{companyId}/add")
	public String getCompanyInfoForm() {
		return "admin/company/add-company-info";
	}

	// 계약 업체 등록
	@PostMapping("/companies/{companyId}/add")
	public String postCompanyInfo() {
		return "redirect:/admin/{buildId}/company/list";
	}

}
