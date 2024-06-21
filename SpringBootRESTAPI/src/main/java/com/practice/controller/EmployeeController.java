package com.practice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.Employee;
import com.practice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;



@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    
    //Adding single employee handler
    @PostMapping("/employee")
    public List<Employee> addEmployee(@RequestBody List<Employee> employeeList) {
        return employeeService.addEmployee(employeeList);
    }

    //Read or get sigle employee using its id handler
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") long id) {
        return employeeService.getEmployee(id);
    }

    //Read or get all employee data handler method
    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }
    
    //Update employee data handler
    @PutMapping("/employee")
    public Employee updatEmployee(@RequestBody Employee employee){
        return employeeService.updatEmployee(employee);
    }
    
    //Delete sigle employee data handler method
    @DeleteMapping("/employee/{id}")
    public Employee deletEmployee(@PathVariable("id") long id){
        return employeeService.deleteEmployee(id);
    }

    //Delete all employee data handler method
    @DeleteMapping("/employee")
    public List<Employee> deleteAllEmployee(){
        return employeeService.deleteAllEmployee();
    }
}
