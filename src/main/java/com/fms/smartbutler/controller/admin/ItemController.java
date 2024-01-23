package com.fms.smartbutler.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {
	
	@GetMapping("/admin/item/add")
	public String itemAdd() {
		return "admin/item/item-add";
	}
	
	@GetMapping("/admin/item/list")
	public String itemList() {
		return "admin/item/item-list";
	}
	
	@GetMapping("/admin/item/info")
	public String itemInfo() {
		return "admin/item/item-info";
	}
	
	@GetMapping("/admin/item/edit")
	public String itemEdit() {
		return "admin/item/item-edit";
	}
}
