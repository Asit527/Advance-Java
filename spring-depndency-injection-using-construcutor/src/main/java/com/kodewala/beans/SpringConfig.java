package com.kodewala.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Bean("address")
	public Address address() {
		Address address = new Address("line-1", "line-2", "BLR", "KA");
		return address;
		
	}
	@Bean("emp")
	public Employee emp() {
		Employee emp = new Employee("Asit", "Nayak", address());
		return emp;
		
	}

}
