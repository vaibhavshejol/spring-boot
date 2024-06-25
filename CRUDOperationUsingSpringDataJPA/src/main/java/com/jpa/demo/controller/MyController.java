package com.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.entities.Employee;
import com.jpa.demo.service.EmployeeService;

import jakarta.annotation.PostConstruct;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		
		Employee addEmp = employeeService.addEmployee(employee);
		return addEmp;
		
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employee/{id}")
	public boolean deleteEmployee(@PathVariable("id") long id ) {
		
		return employeeService.deleteEmployee(id);
	}
}
