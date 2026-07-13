package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.beans.Employee;
import com.kodewala.config.SpringConfig;
import com.kodewala.service.EmployeeService;

public class Driver 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	EmployeeService emp = context.getBean(EmployeeService.class);
    	emp.displayEmpDetails();
    	
    }
}
