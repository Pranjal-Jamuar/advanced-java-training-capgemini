package com.capg;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = context.getBean(Car.class);
        car.drive();
        
//        Employee emp = context.getBean("employee", Employee.class);
//        emp.display();

    }
}
