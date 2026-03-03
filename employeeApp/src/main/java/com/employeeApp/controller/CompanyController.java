package com.employeeApp.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import com.employeeApp.dto.CompanyRequestDTO;
import com.employeeApp.dto.CompanyResponseDTO;
import com.employeeApp.service.CompanyService;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<CompanyResponseDTO> create(
            @Valid @RequestBody CompanyRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(dto));
    }

    // GET ALL
    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> getAll() {

        return ResponseEntity.ok(service.getAll());
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> getById(
            @PathVariable int id) {

        return ResponseEntity.ok(service.getById(id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}