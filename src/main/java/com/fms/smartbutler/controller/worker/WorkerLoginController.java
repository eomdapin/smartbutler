package com.fms.smartbutler.controller.worker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkerLoginController {
	
	@GetMapping("/worker/login")
	public String getLogin() {
		return "worker/login/login";
	}
}
