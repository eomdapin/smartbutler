package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-02-03 ~ 2024-02-03
*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserMainController {
	
	@GetMapping
	public String getUserMainPage() {
		return "user/main/main";
	}
}
