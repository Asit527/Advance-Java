package com.kodewala.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Employee {
	
	@Value("kodewala")
	private String firstName;
	@Value("Academy")
	private String lastName;
	
	// field injection .... autowired
	@Autowired
	private Address address;

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	
	
	
	

}
