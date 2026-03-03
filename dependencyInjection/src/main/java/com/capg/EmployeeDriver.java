package com.capg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeeDriver {
	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Employee e=context.getBean("myEmp", Employee.class);
		System.out.println(e.getId());
		System.out.println(e.getName());
		e.work();
	}
}