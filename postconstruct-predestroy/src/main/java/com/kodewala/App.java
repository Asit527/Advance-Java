package com.kodewala;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.beans.Payment;
import com.kodewala.config.SpringConfig;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringConfig.class);

		Payment pay1 = (Payment) applicationContext.getBean("pay");
		System.out.println(pay1.getPayId());

		Payment pay2 = (Payment) applicationContext.getBean("pay");
		System.out.println(pay2.getPayId());

		System.out.println(pay1 == pay2);

		pay2.destroy();

		applicationContext.close();

	}
}
