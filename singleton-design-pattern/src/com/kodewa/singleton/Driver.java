package com.kodewa.singleton;

public class Driver {
public static void main(String[] args) {
	IntCalc intCalc1= IntCalc.getInStance();
	IntCalc intCalc2= IntCalc.getInStance();
	IntCalc intCalc3= IntCalc.getInStance();
	
	System.out.println(intCalc1==intCalc2);
}
}
