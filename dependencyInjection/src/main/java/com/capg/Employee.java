//package com.capg;
//
//import java.util.List;
//import java.util.Map;
//
//public class Employee {
//
//    private List<String> skills;
//    private Map<String, String> contacts;
//
//    public void setSkills(List<String> skills) {
//        this.skills = skills;
//    }
//
//    public void setContacts(Map<String, String> contacts) {
//        this.contacts = contacts;
//    }
//
//    public void display() {
//        System.out.println("Skills: " + skills);
//        System.out.println("Contacts: " + contacts);
//    }
//}



// Dependency Injection using setters

//package com.capg;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//@Component(value="myEmp")
//public class Employee {
//	
//	private int id;
//	private String name;
//	
//	public void work() {
//		System.out.println("Working");
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	@Value("101")
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//	
//	@Value("Raj")
//	public void setName(String name) {
//		this.name = name;
//	}
//}

// Dependency Injection using Constructor

package com.capg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="myEmp")
public class Employee {
	
	private int id;
	private String name;
		
	public Employee(@Value("100") int id, @Value("Aman") String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee() {
		super();
	}

	public void work() {
		System.out.println("Working");
	}

	public int getId() {
		return id;
	}

//	@Value("101") //Setter DI
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
//	@Value("Raj") //Setter DI
	public void setName(String name) {
		this.name = name;
	}
}