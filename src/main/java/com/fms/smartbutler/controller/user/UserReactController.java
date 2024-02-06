package com.fms.smartbutler.controller.user;

/**
* @author 엄다빈
* @editDate 2024-02-06 ~ 2024-02-06
*/

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserReactController implements ErrorController {
	
	// 리액트 Route 매핑용
	@GetMapping({"/", "/error", "/user/buildings/info"})
	public String getReactPage() {
		return "forward:/index.html";
	}
}
