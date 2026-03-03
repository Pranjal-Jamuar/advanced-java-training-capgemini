package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	@Value("Pranjal")
	private String name;
	private StudentID id;
	
	public Student() {}
	
	@Autowired
	public Student(StudentID id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StudentID getId() {
		return id;
	}

	public void setId(StudentID id) {
		this.id = id;
	}
}