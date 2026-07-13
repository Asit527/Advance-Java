package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.kodewala.beans.Payment;

@Configuration
public class SpringConfig {

	@Bean("pay")
	@Scope("prototype")
	@Profile("dev") // what is @Profile very famous interview Question
	public Payment doPayment() {
		Payment pay = new Payment();
		pay.setPayId("RIF1088");
		return pay;
	}

}
