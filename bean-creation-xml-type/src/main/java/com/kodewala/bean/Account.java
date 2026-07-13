package com.kodewala.bean;

public class Account {
	private String accNo;
	
	
public String getAccNo() {
		return accNo;
	}


	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}


public void printSomething() {
	System.out.println("printing somethings and accNo is "+accNo);
}
}
