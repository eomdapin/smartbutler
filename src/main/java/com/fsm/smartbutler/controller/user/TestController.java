package com.fsm.smartbutler.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@GetMapping("/api/hello")
	public String test() {
		return "야";
	}
	@GetMapping("/hello")
	public String test1() {
		return "야123123";
	}
}
