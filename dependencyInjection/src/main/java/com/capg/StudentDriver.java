package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudentDriver {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); 
		
		Student s=context.getBean("student", Student.class);
		System.out.println(s.getName());
		
		StudentID i=s.getId(); // if autowired is not there this reference of card will be null 
		i.student_ID();
	}
}