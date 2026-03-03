package com.employeeApp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Company() {
    	super();
    }

    public int getId() { 
    	return id; 
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

    public List<Employee> getEmployees() { 
    	return employees; 
    }
    
    public void setEmployees(List<Employee> employees) { 
    	this.employees = employees; 
    }
    
}