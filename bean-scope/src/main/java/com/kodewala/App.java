package com.kodewala;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.beans.Payment;
import com.kodewala.config.SpringConfig;

public class App 
{
    public static void main( String[] args )
    {
      ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
      
      Payment payment1=(Payment) context.getBean("pay");
      System.out.println( payment1.getPaymentId());
      
      Payment payment2=(Payment) context.getBean("pay");
      System.out.println( payment2.getPaymentId());
      
      
      System.out.println(payment1==payment2);
      
      // @Scope("singleton") default scope
      
    }
}
