package com.fms.smartbutler.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuildController {
	
	@GetMapping("/admin/buildlist")
	public String getBuildList(Model model) {
		String[] str = new String[10];
		
		for(int i=0; i<9; i++) {
			str[i] = "0";
		}
		
		model.addAttribute("str", str);
		return "admin/build/build-list";
	}
	
	@GetMapping("/admin/buildlist/{buildId}")
	public String getBuildInfo(@PathVariable Long buildId, Model model) {
		return "admin/build/build-info";
	}
	
	@GetMapping("/admin/build/add")
	public String getBuildAdd(Model model) {
		return "admin/build/build-info";
	}
	
	@PostMapping("/admin/build/add")
	public String postBuildAdd(Model model) {
		return "redirect:/admin/buildlist";
	}
}
