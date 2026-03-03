package com.employeeApp.service;

import org.springframework.stereotype.Service;
import com.employeeApp.repository.*;
import com.employeeApp.entity.*;
import com.employeeApp.exception.*;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company createCompany(Company company) {
        return repository.save(company);
    }

    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    public Company getCompanyById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found"));
    }

    public void deleteCompany(int id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Company not found");
        }
        repository.deleteById(id);
    }
}