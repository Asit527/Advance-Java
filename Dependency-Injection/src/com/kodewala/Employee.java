package com.kodewala;

public class Employee {
	private String firstName;
	private String lasttName;
	private String email;
	Address address;
	
	// for constructor based dependency injection
	public Employee(String firstName, String lasttName, String email, Address address) {
		super();
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
		this.address = address;
	}
	
	
	
	// using setter for dependency injection
	
	public Employee(String firstName, String lasttName, String email) {
		super();
		this.firstName = firstName;
		this.lasttName = lasttName;
		this.email = email;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	

}
