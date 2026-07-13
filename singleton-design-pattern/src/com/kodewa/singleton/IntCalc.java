package com.kodewa.singleton;

public class IntCalc {
	private static  IntCalc intCalc;
	
	// private constructor bcz to make it singleton
	private IntCalc() {
		
	}
	
	
	// this method so another class can get the instance
	
	public static  synchronized IntCalc getInStance() {
		if(intCalc==null) {
			intCalc= new IntCalc();
			System.out.println("giving initial value");
		}
		else {
			System.out.println("Object alreday intialised");
			
		}
		
		return intCalc;
	}
	

}
