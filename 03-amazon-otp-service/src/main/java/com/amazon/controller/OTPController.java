package com.amazon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.request.OTPRequest;
import com.amazon.response.OTPResponse;
import com.amazon.service.OTPService;

@RestController
@RequestMapping("otp")
public class OTPController {
	
	@Autowired
	OTPService otpService;
	
	@PostMapping("/generate")
	public OTPResponse generateOtp(@RequestBody OTPRequest otpRequest)
	{
		String name = otpRequest.getName();
		String mobile = otpRequest.getMobile();
		OTPResponse otpResponse = otpService.saveOtp(name, mobile);
		return otpResponse;
	}
	
	
	@PostMapping("/validate/{mobile}/{otp}")
	public String validateOtp(@PathVariable("mobile") String mobile, @PathVariable("otp") String otp  ) {
		 return otpService.validateOtp(mobile, otp);
	}

	

}
