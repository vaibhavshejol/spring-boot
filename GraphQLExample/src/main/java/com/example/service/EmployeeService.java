package com.example.service;

import com.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee employee);

    public Employee getEmployee(Integer id);

    public List<Employee> getAllEmployees();

    public boolean deleteEmployee(Integer id);
}
