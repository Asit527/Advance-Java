package com.kodewala.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kodewala.payment.pojo.Payment;

@Configuration
public class SpringConfig {
	@Bean("bean1")
	public Payment checkPayment1() {
		Payment payment= new Payment();
		payment.setRefId("OD1232");
		payment.setStatus("Hold");
		return payment;
	}
	@Bean("bean2")
	public Payment checkPayment2() {
		Payment payment= new Payment();
		payment.setRefId("KA831232");
		payment.setStatus("Sucess");
		return payment;
	}

}
