package com.kodewala.payment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kodewala.payment.config.SpringConfig;
import com.kodewala.payment.pojo.Payment;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext iocContainer = new AnnotationConfigApplicationContext(SpringConfig.class);
        
       Payment payment1 =(Payment) iocContainer.getBean("bean1");
       System.out.println("payment id: "+ payment1.getRefId()+" payment status: "+payment1.getStatus());
       System.out.println("====================");
       Payment payment2 =(Payment) iocContainer.getBean("bean2");
       System.out.println("payment id: "+ payment2.getRefId()+" payment status: "+payment2.getStatus());
    }
}
