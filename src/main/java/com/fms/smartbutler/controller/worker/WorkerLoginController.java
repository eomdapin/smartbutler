package com.fms.smartbutler.controller.worker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
