package com.employeeApp.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.employeeApp.entity.Company;
import com.employeeApp.service.CompanyService;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Company> create(@Valid @RequestBody Company company) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createCompany(company));
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}