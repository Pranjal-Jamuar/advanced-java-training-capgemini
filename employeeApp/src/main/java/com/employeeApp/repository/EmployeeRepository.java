package com.employeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeeApp.entity.Employee;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByEmail(String email);
    List<Employee> findByPhone(String phone);
}