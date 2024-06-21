package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
