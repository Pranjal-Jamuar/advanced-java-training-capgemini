package com.employeeApp.service;

import org.springframework.stereotype.Service;
import com.employeeApp.entity.Company;
import com.employeeApp.dto.CompanyRequestDTO;
import com.employeeApp.dto.CompanyResponseDTO;
import com.employeeApp.repository.CompanyRepository;
import com.employeeApp.exception.ResourceNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    // CREATE COMPANY
    public CompanyResponseDTO create(CompanyRequestDTO dto) {

        Company company = new Company();
        company.setName(dto.getName());
        company.setLocation(dto.getLocation());

        Company saved = repository.save(company);

        return mapToDTO(saved);
    }

    // GET ALL COMPANIES
    public List<CompanyResponseDTO> getAll() {

        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // GET COMPANY BY ID
    public CompanyResponseDTO getById(int id) {

        Company company = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Company not found"));

        return mapToDTO(company);
    }

    // DELETE COMPANY
    public void delete(int id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Company not found");
        }

        repository.deleteById(id);
    }

    // MAPPING METHOD
    private CompanyResponseDTO mapToDTO(Company company) {

        CompanyResponseDTO dto = new CompanyResponseDTO();

        dto.setId(company.getId());
        dto.setName(company.getName());
        dto.setLocation(company.getLocation());

        return dto;
    }
}