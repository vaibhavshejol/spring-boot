package com.practice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.practice.entities.Employee;
import com.practice.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    //Adding employee handler method
    @PostMapping("/employee")
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody List<Employee> employeeList) {
        
            // Here we check the given list is empty or not. If empty then we send status as "Not modified".
            if(employeeList==null || employeeList.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
            }
            else{
                List savedEmployees=employeeService.addEmployee(employeeList);
                
                //Here we check list successfully added or not. If list is empty means not added then here also we send the status as "Not modified".
                if(savedEmployees.isEmpty()){
                    return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
                }
                else{
                    // Here we send the status as "Created" means list successfully added.
                    return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployees);
                }
            }
    }

    //Read or get sigle employee using its id handler
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Employee employee=employeeService.getEmployee(id);
        // Here if employee bobject is not null means data found so we send status as found
        if(employee!=null){
            return ResponseEntity.status(HttpStatus.FOUND).body(employee);
        }
        else{
            //Here if employee object is null the we send status as not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    //Read or get all employee data handler method
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List employeeList=employeeService.getAllEmployee();
        //If in database employees data are present mean list cannot be empty so we send status as ok.
        if(!employeeList.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body(employeeList);
        }
        else{
            // If there is no data present then we send status as no content.
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
    }
    
    //Update employee data handler
    @PutMapping("/employee")
    public ResponseEntity<Employee> updatEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.updatEmployee(employee);
        if(updatedEmployee!=null){
            //If employee data updated successfully then here we send status as ok.
            return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
        }
        else{
            // If data not updated then we send status as not modified.
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }
    
    //Delete sigle employee data handler method
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deletEmployee(@PathVariable("id") long id){
        Employee employee = employeeService.deleteEmployee(id);
        if(employee!=null){
            // Here if employee data deleted successfully then we send status as ok.
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        }
        else{
            //Here if data is not deleted then we send status as not modified
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }

    //Delete all employee data handler method
    @DeleteMapping("/employee")
    public ResponseEntity<List<Employee>> deleteAllEmployee(){
        List deletedEmployeesList = employeeService.deleteAllEmployee();
        if(!deletedEmployeesList.isEmpty()){
            //Here if list is not empty means all employee data is deleted so we send status as ok
            return ResponseEntity.status(HttpStatus.OK).body(deletedEmployeesList);
        }
        else{
            //Here if data is not deleted from database then we send status as not modified.
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(null);
        }
    }
}
