package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	// 시설 등록
	@GetMapping("/admin/item/add")
	public String itemAdd() {
		return "admin/item/item-add";
	}
	
	// 시설 목록
	@GetMapping("/admin/item/list")
	public String itemList() {
		return "admin/item/item-list";
	}
	
	// 시설 상세
	@GetMapping("/admin/item/info")
	public String itemInfo() {
		return "admin/item/item-info";
	}
	
	// 시설 수정
	@GetMapping("/admin/item/edit")
	public String itemEdit() {
		return "admin/item/item-edit";
	}
}
