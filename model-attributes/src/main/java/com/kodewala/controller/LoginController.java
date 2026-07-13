package com.kodewala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.kodewala.request.LoginRequest;

@Controller
public class LoginController {

	@PostMapping("signup")
	public String reqLogin(@ModelAttribute LoginRequest request ,Model model) {
		System.out.println(request.getFirstName());
		System.out.println(request.getLastName());
		System.out.println(request.getPhone());
		System.out.println(request.getEmail());
		
		model.addAttribute("userId",request.getPhone()); // key and value that can be accessed in page
		
		return "signup-sucess";
	}
}
