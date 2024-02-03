package com.fms.smartbutler.controller.worker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 전종배
 * @since 2024-01-25 to 2024-01-31
 */

@Controller
@RequestMapping("/worker")
public class WorkerLoginController {
	
	@GetMapping("/login")
	public String getLogin() {
		return "worker/login/login";
	}
	
	@GetMapping("/login/hello")
	public String hello() {
		return "worker/login/hello";
	}
}
