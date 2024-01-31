package com.fms.smartbutler.controller.admin;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.CostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class CostController {
	
	private final CostService costService;
	private final BuildService buildService;
	
	// 관리비 목록
	@GetMapping("/{buildId}/costs")
	public String getCostList(@RequestParam(required = false) Long buildId, Model model) {
		List<CostDTO> costs = costService.findByBuildId(buildId);
		List<BuildDTO> builds = buildService.findAll();
		BuildDTO build = buildService.findById(buildId);
		
		model.addAttribute("costs", costs);
		model.addAttribute("build", build);
		model.addAttribute("builds", builds);
		
		return "admin/cost/cost-list";
	}
	
	// 관리비 입력
	@GetMapping("/{buildId}/costs/add")
	public String gerAddCost(@PathVariable Long buildId, @ModelAttribute CostDTO costDTO, Model model) {
		BuildDTO buildDTO = buildService.findById(buildId);
		model.addAttribute("build", buildDTO);
		
		return "admin/cost/cost-add";
	}
	
	// 관리비 저장
	@PostMapping("/{buildId}/costs/add")
	public String postAddCost(@PathVariable Long buildId, @ModelAttribute CostDTO costDTO, Model model) {
		costDTO.setBuildId(buildId);
		
		if(costService.save(costDTO)) {
			log.info("costDTO.getCostId() :::: {} ", costDTO.getCostId());
			model.addAttribute("costId", costDTO.getCostId());
			model.addAttribute("buildId", buildId);
			return "/admin/cost/cost-error";
		}
		
		return "redirect:/admin/buildings/{buildId}/costs";
	}
	
	// 관리비 상세
	@GetMapping("/{buildId}/costs/{costId}")
	public String getCostInfo(@PathVariable Long buildId, @PathVariable Long costId, Model model) {
		BuildDTO buildDTO = buildService.findById(buildId);
		CostDTO costDTO = costService.findById(costId);
		
		model.addAttribute("build", buildDTO);
		model.addAttribute("costDTO", costDTO);
		
		return "admin/cost/cost-info";
	}
	
	// 관리비 수정 폼
	@GetMapping("/{buildId}/costs/{costId}/edit")
	public String getCostEdit(@PathVariable Long buildId, @PathVariable Long costId, Model model) {
		BuildDTO buildDTO = buildService.findById(buildId);
		CostDTO costDTO = costService.findById(costId);
		
		model.addAttribute("build", buildDTO);
		model.addAttribute("costDTO", costDTO);
		
		return "admin/cost/cost-edit";
	}
	
	// 관리비 수정
	@PostMapping("/{buildId}/costs/{costId}/edit")
	public String putCostEdit(@PathVariable Long buildId, @PathVariable Long costId, @ModelAttribute CostDTO costDTO, Model model) {
		costDTO.setCostId(costId);
		costService.updateCost(costDTO);
		
		return "redirect:/admin/buildings/{buildId}/costs";
	}
	
	// 관리비 전송
	@PostMapping("/{buildId}/costs/{costId}/send")
	public String putCostSubmit(@PathVariable Long buildId, @PathVariable Long costId, @ModelAttribute CostDTO costDTO) {
		costDTO.setCostId(costId);
		costService.updateCost(costDTO);
		
		return "redirect:/admin/buildings/{buildId}/costs";
	}
}
