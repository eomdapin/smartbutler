package com.fms.smartbutler.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.dto.ItemDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ItemService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/buildings/{buildId}/items")
@RequiredArgsConstructor
public class ItemController {
	
	private final ItemService itemService;
	private final BuildService buildService;
	
	// 시설 목록
	@GetMapping
	public String getItemList(@RequestParam(required = false) Long buildId, Model model) {
		buildId = buildId == null ? 1 :buildId;
		Build build = buildService.findById(buildId).orElseGet(Build::new);
		List<Build> builds = buildService.findAll();
		List<ItemDTO> items = itemService.findByBuildId(buildId);
		
		model.addAttribute("build", build);
		model.addAttribute("builds", builds);
		model.addAttribute("items", items);
		
		return "admin/item/item-list";
	}
	
	// 시설 상세
	@GetMapping("/{itemId}")
	public String getItemInfo(@PathVariable("itemId") Long itemId, Model model) {
//		Optional<ItemDTO> itemDTO = itemService.findById(itemId);
		ItemDTO itemDTO = itemService.findById(itemId).orElseGet(ItemDTO::new);
//		Optional<Build> build = buildService.findById(buildId);
		
		model.addAttribute("item", itemDTO);
//		model.addAttribute("build", build.get());
		
		return "admin/item/item-info";
	}
	
	// 시설 등록 폼
	@GetMapping("/add")
	public String getItemAdd(@PathVariable Long buildId, Model model) {
		Optional<Build> build = buildService.findById(buildId);
		
		model.addAttribute("build", build.get());
		
		return "admin/item/item-add";
	}
	
	// 시설 등록
	@PostMapping("/add")
	public String postItemAdd(@ModelAttribute ItemDTO itemDTO) throws Exception {
		itemService.insert(itemDTO);
		
		return "redirect:/admin/buildings/{buildId}/items";
	}
	
	// 시설 수정 폼
	@GetMapping("/{itemId}/edit")
	public String getItemEdit(@PathVariable("itemId") Long itemId, Model model) {
		ItemDTO itemDTO = itemService.findById(itemId).orElseGet(ItemDTO::new);
		
		model.addAttribute("item", itemDTO);
		
		return "admin/item/item-edit";
	}
	
	// 시설 수정
	@PutMapping("/{itemId}/edit")
	public String putItemEdit(@ModelAttribute ItemDTO itemDTO) throws Exception {
		itemService.update(itemDTO);
		
		return "redirect:/admin/buildings/{buildId}/items";
	}
	
	// 시설 삭제
	@DeleteMapping("/{itemId}")
	public String deleteItem(@ModelAttribute ItemDTO itemDTO) {
		itemService.delete(itemDTO);
		
		return "redirect:/admin/buildings/{buildId}/items";
	}
	
}
