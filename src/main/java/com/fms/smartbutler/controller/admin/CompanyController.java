package com.fms.smartbutler.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Company;
import com.fms.smartbutler.dto.CompanyDTO;
import com.fms.smartbutler.service.CompanyService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/buildings")
public class CompanyController {

	private final CompanyService companyService;

	// 계약 업체 목록
	@GetMapping("/companies")
	public String getCompanyList(Model model) {
		List<CompanyDTO> companiesDTO = companyService.findAll();
		model.addAttribute("companies", companiesDTO);
		return "admin/company/company-list";
	}

	// 계약 업체 상세
	@GetMapping("/{buildId}/companies/{companyId}")
	public String getCompanyInfo(@PathVariable Long companyId, Model model) {
		CompanyDTO companyDTO = companyService.findById(companyId);
		model.addAttribute("company", companyDTO);
		return "admin/company/company-info";
	}

	// 계약 업체 수정 폼
//	@GetMapping("/companies/{companyName}/update")
//	public String getCompanyInfoUpdateForm() {
//		return "admin/company/update-company-info";
//	}

	// 계약 업체 수정 폼
	@GetMapping("/{buildId}/companies/{companyId}/update")
	public String getCompanyInfoUpdateForm(@PathVariable Long companyId, Model model) {
		CompanyDTO companyDTO = companyService.findById(companyId);
		model.addAttribute("company", companyDTO);
		return "admin/company/update-company-info";
//		return "admin/company/hello";
	}

	// 계약 업체 수정
//	@PostMapping("/companies/{companyName}/update")
//	public String updateCompanyInfo() {
//		return "redirect:/admin/buildings/companies";
//	}

	// 계약 업체 수정
	@PostMapping("/{buildId}/companies/{companyId}/update")
	public String updateCompanyInfo(@PathVariable Long companyId, @ModelAttribute CompanyDTO companyDTO) {
		companyService.save(companyDTO);
		return "redirect:/admin/buildings/companies";
	}

	// 계약 업체 삭제
//	@GetMapping("/companies/{companyId}/delete")
//	public String deleteCompanyInfo(@PathVariable Long companyId) {
//		companyService.deleteById(companyId);
//		return "redirect:/admin/buildings/companies";
//	}

	// 계약 업체 삭제
	@PostMapping("/{buildId}/companies/{companyId}/delete")
	public String deleteCompanyInfo(@PathVariable Long companyId) {
		companyService.deleteById(companyId);
		return "redirect:/admin/buildings/companies";
	}

	// 계약 업체 등록 폼
	@GetMapping("/companies/add")
	public String getCompanyInfoForm() {
		return "admin/company/add-company-info";
	}

	// 계약 업체 등록
	@PostMapping("/companies/add")
	public String addCompanyInfo(@ModelAttribute CompanyDTO companyDTO) {

		companyService.save(companyDTO);

		return "redirect:/admin/buildings/companies";
	}

}
