package com.kodewala;

public class Driver {
	public static void main(String[] args) {
		
		// constructor based dependency injection (mandatory need dependency and immutable )
		Address address1 =new Address("12th ", "Udipi signal", "", "BLR", "KA", "000000", "IND");
		Employee employee1 = new Employee("Asit", "Nayak", "asit@kodewala.com", address1);
		
		
		
		
		// using setter for dependency injection	(optionally need dependency and mutable )
		
		Employee employee2 = new Employee("Asit", "Nayak", "asit@kodewala.com");
		
		Address address2 =new Address("12th ", "Udipi signal", "", "BLR", "KA", "000000", "IND");
		employee2.setAddress(address2);
		Address address3 =new Address("13th ", "ree", "", "BLR", "KA", "000000", "IND");
		employee2.setAddress(address3);
		
	}

}
