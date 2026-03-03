package com.capg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value="myCollege")
public class College {
	
	@Value("1")
	private int id;
	private String name;
	private String location;
	private String department;
		
	public College(@Value("LPU") String name, @Value("Punjab") String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public String getDepartment() {
		return department;
	}
	
	@Value("CSE")
	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}