package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.beans.Employee;
import com.kodewala.beans.SpringConfig;

public class Driver 
{
    public static void main( String[] args )
    {
      ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
       Employee emp =(Employee) context.getBean(Employee.class);
       System.out.println(emp.toString());
    }
}
