package com.kodewala.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.kodewala.beans.Employee;

@Configuration
@ComponentScan(basePackages ="com.kodewala")
// scanning beans
public class SpringConfig {
	
	@Bean("emp1")

	
	public Employee createEmp1() {
		Employee e = new Employee("Asit1", "Nayak1", "Software");
		return e;
	}

	@Bean("emp2")
//	@Primary
	
	public Employee createEmp2() {
		Employee e = new Employee("Asit2", "Nayak2", "Software");
		return e;
	}

}
