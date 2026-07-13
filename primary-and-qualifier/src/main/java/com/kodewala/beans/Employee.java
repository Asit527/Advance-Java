package com.kodewala.beans;


public class Employee {
	private String firstName;
	private String lastName;
	private String department;
	
	
	

	public Employee(String firstName, String lastName, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
	}




	public void display() {
		System.out.println("Employee [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department + "]");
	}
	
	
	

}
