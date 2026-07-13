package com.kodewala.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
	@Bean("address")
	public Address createAddress() {
		Address address = new Address("x", "x", "x", "x");
		return address;
		
		
	}
	@Bean("emp")
	public Employee emp() {
		Employee emp = new Employee();
		emp.setFirstName("Asit");
		emp.setLastName("Nayak");
		emp.setAddress(createAddress());
		return emp;
		
	}

}
