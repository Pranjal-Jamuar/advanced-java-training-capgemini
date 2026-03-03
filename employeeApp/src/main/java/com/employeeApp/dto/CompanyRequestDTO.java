package com.employeeApp.dto;

import jakarta.validation.constraints.NotBlank;

public class CompanyRequestDTO {

    @NotBlank(message = "Company name required")
    private String name;

    @NotBlank(message = "Location required")
    private String location;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}