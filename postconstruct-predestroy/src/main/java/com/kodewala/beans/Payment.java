package com.kodewala.beans;
import javax.annotation.*;

public class Payment {
	private String payId;

	public Payment() {
		System.out.println("1. bean instantiated");
	}

	public String getPayId() {
		return payId;
	}
	
	public void setPayId(String payId) {
		this.payId = payId;
		System.out.println("2. Dependency injected");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("3. bean intialised");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("4. bean destroyed ");
	}

	
}
