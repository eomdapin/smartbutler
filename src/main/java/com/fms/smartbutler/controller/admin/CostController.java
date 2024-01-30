package com.fms.smartbutler.controller.admin;

import java.util.List;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-02-03
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.dto.CostDTO;
import com.fms.smartbutler.service.CostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin/buildings")
@RequiredArgsConstructor
public class CostController {
	
	private final CostService costService;

	@GetMapping("/{buildId}/costs")
	public String getCostList(Model model) {
		List<CostDTO> costs = costService.findAll();
		
		model.addAttribute("costs", costs);
		
//		log.info("costs.get(0).getCostId() :: {}", costs.get(0).getCostId());
//		log.info("costs.get(0).getBuildId() :: {}", costs.get(0).getBuildId());
//		log.info("costs.get(0).getElectricity() :: {}", costs.get(0).getElectricity());
//		log.info("costs.get(0).getCostKinds().get(0).getElectricity() :: {}", costs.get(0).getCostKinds().get(0));
		
		return "admin/cost/cost-list";
	}
	
}
