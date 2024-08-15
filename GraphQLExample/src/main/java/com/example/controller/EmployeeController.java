package com.example.controller;

import com.example.service.EmployeeService;
import com.example.entity.Employee;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);

    }

//    @GetMapping("/employee/{id}")
    @QueryMapping("getEmployee")
    public Employee getEmployees(/*@PathVariable("id")*/ @Argument Integer id){

        return employeeService.getEmployee(id);
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public boolean deleteEmployee(@PathVariable("id") Integer id ) {

        return employeeService.deleteEmployee(id);
    }
}
