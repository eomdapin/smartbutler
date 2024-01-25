package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/items")
public class ItemController {
	
	// 시설 등록
	@GetMapping("/add")
	public String getItemAdd() {
		return "admin/item/item-add";
	}
	
	// 시설 목록
	@GetMapping
	public String getItemList() {
		return "admin/item/item-list";
	}
	
	// 시설 상세
	@GetMapping("/info")
	public String getItemInfo() {
		return "admin/item/item-info";
	}
	
	// 시설 수정
	@GetMapping("/edit")
	public String getItemEdit() {
		return "admin/item/item-edit";
	}
}
