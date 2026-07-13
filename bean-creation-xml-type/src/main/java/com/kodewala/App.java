package com.kodewala;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kodewala.bean.Account;


public class App 
{
    public static void main( String[] args )
  
    {
    	  String bean_def_file="/beans.xml";
    	  
    	// creating IOC container
     ApplicationContext  iocContainer = new ClassPathXmlApplicationContext(bean_def_file);
     // request for bean
     Account account=(Account) iocContainer.getBean("acc");
    account.printSomething();
    }
}
