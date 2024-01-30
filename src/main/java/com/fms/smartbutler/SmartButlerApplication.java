package com.fms.smartbutler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SmartButlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartButlerApplication.class, args);
	}
}
