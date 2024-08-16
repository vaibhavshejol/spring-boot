package com.example.controller;

import com.example.service.EmployeeService;
import com.example.entity.Employee;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);

    }

//    @GetMapping("/{id}")
    @QueryMapping("getEmployee")
    public Employee getEmployees(/*@PathVariable("id")*/ @Argument Integer id){

        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){

        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable("id") Integer id ) {

        return employeeService.deleteEmployee(id);
    }
}
