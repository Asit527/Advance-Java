package com.kodewala.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {
	
	@GetMapping("login")
	public String login() {
		return "login sucess";
	}
}
