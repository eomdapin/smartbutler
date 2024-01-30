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

import com.fms.smartbutler.dto.BuildDTO;
import com.fms.smartbutler.dto.ItemDTO;
import com.fms.smartbutler.service.BuildService;
import com.fms.smartbutler.service.ItemService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		BuildDTO buildDTO = buildService.findById(buildId);
		List<BuildDTO> builds = buildService.findAll();
		List<ItemDTO> items = itemService.findByBuildId(buildId);
		
		model.addAttribute("build", buildDTO);
		model.addAttribute("builds", builds);
		model.addAttribute("items", items);
		
		return "admin/item/item-list";
	}
	
	// 시설 상세
	@GetMapping("/{itemId}")
	public String getItemInfo(@PathVariable Long itemId, Model model) {
		ItemDTO itemDTO = itemService.findById(itemId).orElseGet(ItemDTO::new);
		
		model.addAttribute("item", itemDTO);
		
		return "admin/item/item-info";
	}
	
	// 시설 등록 폼
	@GetMapping("/add")
	public String getItemAdd(@PathVariable Long buildId, Model model) {
		Optional<ItemDTO> itemDTO = itemService.findById(buildId);
		List<ItemDTO.ItemKindDTO> itemKind = itemService.findAllItemKind();
		
		model.addAttribute("item", itemDTO.get());
		model.addAttribute("itemKind", itemKind);
		
		return "admin/item/item-add";
	}
	
	// 시설 등록
	@PostMapping("/add")
	public String postItemAdd(@PathVariable Long buildId, @ModelAttribute ItemDTO itemDTO) throws Exception {
		itemService.insert(itemDTO);
		
		return "redirect:/admin/buildings/{buildId}/items";
	}
	
	// 시설 수정 폼
	@GetMapping("/{itemId}/edit")
	public String getItemEdit(@PathVariable Long itemId, Model model) {
		ItemDTO itemDTO = itemService.findById(itemId).orElseGet(ItemDTO::new);
		
		model.addAttribute("item", itemDTO);
		
		return "admin/item/item-edit";
	}
	
	// 시설 수정
	@PutMapping("/{itemId}/edit")
	public String putItemEdit(@PathVariable Long buildId, @ModelAttribute ItemDTO itemDTO) throws Exception {
		
		log.info("itemDTO >> " + itemDTO.getItemName());
		log.info("itemDTO >> " + itemDTO.getKindType());
		
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
