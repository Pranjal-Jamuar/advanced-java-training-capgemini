package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CollegeDriver {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		College c=context.getBean("myCollege", College.class);
		System.out.println(c.getId());
		System.out.println(c.getName());
		System.out.println(c.getLocation());
		System.out.println(c.getDepartment());
	}
}