package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Order;

public class MainApp {

  public static void main(String[] args) {
     ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
     Order or=context.getBean(Order.class);
     or.display();
     ApplicationContext context1=new ClassPathXmlApplicationContext("applicationContext.xml");
        Order or1=(Order) context1.getBean(Order.class);
        or1.display();
  }

}
