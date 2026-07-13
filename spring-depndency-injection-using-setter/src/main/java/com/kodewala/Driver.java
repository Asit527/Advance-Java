package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.beans.Employee;
import com.kodewala.beans.SpringConfig;

public class Driver 
{
    public static void main( String[] args )
    {
      ApplicationContext conext = new AnnotationConfigApplicationContext(SpringConfig.class);
      Employee emp = (Employee) conext.getBean("emp");
      System.out.println(emp.toString());
    }
}
