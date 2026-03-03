package com.employeeApp.dto;

import java.io.Serializable;

public class CompanyResponseDTO implements Serializable {

    private static final long serialVersionUID = 1l;
	
	private int id;
    private String name;
    private String location;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}