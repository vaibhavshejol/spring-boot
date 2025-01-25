package com.example.controller;

import com.example.service.EmployeeService;
import com.example.entity.Employee;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    Logger logger = Logger.getLogger(EmployeeController.class.getName());

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        logger.info("Dependencies injected.");
        this.employeeService=employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Request is recieved for create employee with : "+employee);
        return employeeService.createEmployee(employee);

    }

//    @GetMapping("/{id}")
    @QueryMapping("getEmployee")
    public Employee getEmployees(/*@PathVariable("id")*/ @Argument Integer id){
        logger.info("Request recieved for get employee with id : "+id);
        return employeeService.getEmployee(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        logger.info("Request recieved for get all employees.");
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public boolean deleteEmployee(@PathVariable("id") Integer id ) {
        logger.info("Request recieved to delete employee with id : "+id);
        return employeeService.deleteEmployee(id);
    }
}
