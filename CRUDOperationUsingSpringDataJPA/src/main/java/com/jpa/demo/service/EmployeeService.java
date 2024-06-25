package com.jpa.demo.service;

import java.util.List;

import com.jpa.demo.entities.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee updateEmployee(Employee employee);

	public boolean deleteEmployee(long id);
}
