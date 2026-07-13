package com.kodewala.beans;

public class Employee {
	private String firstName;
	private String lastName;
	private Address address;
	
	
	


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public void setAddress(Address address) {
		this.address = address;
	}





	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
	
	
	
	
	
}
