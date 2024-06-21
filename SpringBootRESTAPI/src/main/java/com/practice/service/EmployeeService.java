package com.practice.service;

import java.util.List;

import com.practice.entities.Employee;

public interface EmployeeService {
    
    public List<Employee> addEmployee(List<Employee> employeeList);
    public Employee getEmployee(long id);
    public List<Employee> getAllEmployee();
    public Employee updatEmployee(Employee employee);
    public Employee deleteEmployee(long id);
    public List<Employee> deleteAllEmployee();
    
}
