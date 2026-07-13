package com.amazon.service;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.entity.Entity;
import com.amazon.repository.OTPRepository;
import com.amazon.response.OTPResponse;

@Service
public class OTPService {

	@Autowired
	private OTPRepository otpRepository;

	public String generateOTP() {
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000); // Generates 100000 to 999999
		System.out.println(" Generated OTP :::: " + otp);
		return String.valueOf(otp);
	}

	public OTPResponse saveOtp(String name, String mobile) {

		Entity entity = new Entity();
		entity.setOtp(generateOTP());
		entity.setStatus("Active");
		entity.setMobile(mobile);
		entity.setName(name);

		Entity response = otpRepository.save(entity);
		if (response.getId() > 0) {
			System.out.println(" Otp saved successfully......");
		} else {
			System.out.println(" Unable to save the otp");
		}
		OTPResponse otpResponse = new OTPResponse();

		otpResponse.setOtp(response.getOtp());
		otpResponse.setStatus(response.getStatus());
		otpResponse.setValid("5 mins");

		return otpResponse;

	}

	public String validateOtp(String mobile, String otp) {
		Entity entity = otpRepository.findByMobile(mobile);

		if (entity == null) {
			return "mobile number is not  present";

		} else {
			if (entity.getOtp() .equals(otp)) {
				return "otp is valid";
			}
			else {
				return "otp is invalid";
			}

		}

		

	}
}
