package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.kodewala.beans.Payment;

@Configuration
public class SpringConfig {

	@Bean("pay")
	@Scope("prototype")
	public Payment doPayment() {
		Payment pay = new Payment();
		pay.setPaymentId("Asit123");
		return pay;
	}

}
