package com.employeeApp.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.employeeApp.entity.*;
import com.employeeApp.dto.*;
import com.employeeApp.repository.*;
import com.employeeApp.exception.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    public EmployeeResponseDTO create(EmployeeRequestDTO dto) {

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setEmail(dto.getEmail());
        emp.setAge(dto.getAge());
        emp.setPhone(dto.getPhone());

        Employee saved = employeeRepository.save(emp);

        return mapToDTO(saved);
    }

    public List<EmployeeResponseDTO> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @CacheEvict(value = "employees", key = "#empId")
    public EmployeeResponseDTO assign(int empId, int compId) {

        Employee emp = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        Company comp = companyRepository.findById(compId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found"));

        emp.setCompany(comp);
        return mapToDTO(employeeRepository.save(emp));
    }

    private EmployeeResponseDTO mapToDTO(Employee emp) {

        EmployeeResponseDTO dto = new EmployeeResponseDTO();

        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setAge(emp.getAge());
        dto.setPhone(emp.getPhone());

        if (emp.getCompany() != null) {
            dto.setCompanyId(emp.getCompany().getId());
            dto.setCompanyName(emp.getCompany().getName());
        }

        return dto;
    }

    @Cacheable(value = "employees", key = "#id")
    public EmployeeResponseDTO getById(int id) {

        System.out.println("Fetching employee from DB...");

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found"));

        return mapToDTO(employee);
    }
}