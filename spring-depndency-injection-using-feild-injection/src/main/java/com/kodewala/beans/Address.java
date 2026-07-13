package com.kodewala.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Address {
@Value("12th main")
private String line1;
@Value("16th cross")
private String line2;
@Value("BLR")
private String city;
@Value("KA")
private String state;

@Override
public String toString() {
	return "Address [line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state + "]";
}




}
