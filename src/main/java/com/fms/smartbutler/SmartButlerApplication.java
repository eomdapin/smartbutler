package com.fms.smartbutler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@SpringBootApplication
public class SmartButlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartButlerApplication.class, args);
	}
}
