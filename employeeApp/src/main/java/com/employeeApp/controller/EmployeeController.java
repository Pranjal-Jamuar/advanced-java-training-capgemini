package com.employeeApp.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.employeeApp.entity.Employee;
import com.employeeApp.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@Valid @RequestBody Employee employee) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.createEmployee(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PutMapping("/{employeeId}/assign/{companyId}")
    public ResponseEntity<Employee> assign(@PathVariable int employeeId,
                                           @PathVariable int companyId) {
        return ResponseEntity.ok(
                service.assignEmployeeToCompany(employeeId, companyId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}