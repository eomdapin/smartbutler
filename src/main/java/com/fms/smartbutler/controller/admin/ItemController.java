package com.fms.smartbutler.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fms.smartbutler.domain.Build;
import com.fms.smartbutler.domain.Item;
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
	public String getItemList(@PathVariable Long buildId, Model model) {
		List<Item> item = itemService.findAll();
		Optional<Build> build = buildService.findById(buildId);
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setBuild(build.get());
		
		model.addAttribute("item", item);
		model.addAttribute("build", build);
		
		return "admin/item/item-list";
	}
	
	// 시설 상세
	@GetMapping("/{itemId}")
	public String getItemInfo(@PathVariable Long itemId, Model model) {
		Item item = itemService.findById(itemId).orElseGet(Item::new);
		
		model.addAttribute("item", item);
		
		return "admin/item/item-info";
	}
	
	// 시설 등록
	@GetMapping("/add")
	public String getItemAdd(Model model) {
		return "admin/item/item-add";
	}
	
	// 시설 등록 저장
	@PostMapping("/add")
	public String postItemAdd(@ModelAttribute Item item, Model model) {
		itemService.insert(item);
		return "redirect:/admin/buildings/{buildId}/items";
	}
	
	// 시설 수정
	@GetMapping("/edit")
	public String getItemEdit() {
		return "admin/item/item-edit";
	}
	
	// 시설 삭제
	@PostMapping("/{itemId}")
	public String postItemDelete(@PathVariable Long itemId) {
		Item item = itemService.findById(itemId).orElseGet(Item::new);
		itemService.delete(item);
		
		return "redirect:/admin/buildings/{buildId}/items";
	}
	
}
