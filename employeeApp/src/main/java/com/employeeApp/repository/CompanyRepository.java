package com.employeeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.employeeApp.entity.Company;
import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    List<Company> findByName(String name);
}