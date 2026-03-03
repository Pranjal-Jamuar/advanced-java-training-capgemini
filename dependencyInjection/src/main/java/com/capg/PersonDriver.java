package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PersonDriver {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class); // creating the container
		
		Person p = context.getBean("person", Person.class);
//		System.out.println(p.getId());
//		System.out.println(p.getName());
//		
//		AdharCard card=p.getCard(); // if autowired is not there this reference of card will be null 
//		card.getInfo();
		
		Vehicle v=p.getV();
		v.start();
		
	}
}