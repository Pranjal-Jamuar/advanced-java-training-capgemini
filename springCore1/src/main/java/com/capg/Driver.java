package com.capg;

//import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		
		System.out.println("Main start");
//		Student student = new Student();
//		Student student = (Student)context.getBean("myStudent");	// Down-Casting
		Student student = context.getBean("myStudent", Student.class);	// IOC
		student.Study();
		Employee e = context.getBean("emp", Employee.class);
		e.work();
		System.out.println("Main end");

	}

}
