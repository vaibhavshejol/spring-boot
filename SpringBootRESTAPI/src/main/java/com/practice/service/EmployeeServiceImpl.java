package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entities.Employee;
import com.practice.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> addEmployee(List<Employee> employeeList) {
        // TODO Auto-generated method stub
        return employeeRepository.saveAll(employeeList);
    }

    @Override
    public Employee getEmployee(long id) {
        // TODO Auto-generated method stub
        Optional<Employee> optional=employeeRepository.findById(id);
        return optional.get();
        // return (Employee) employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployee() {
        // TODO Auto-generated method stub
        List<Employee> optional=employeeRepository.findAll();
        return optional;
    }

    @Override
    public Employee updatEmployee(Employee employee) {
        // TODO Auto-generated method stub
        Employee employee2=employeeRepository.findById(employee.getId()).get();
        employee2.setName(employee.getName());
        employee2.setEmail(employee.getEmail());
        employee2.setContact(employee.getContact());
        
        return (Employee) employeeRepository.save(employee2);
    }

    @Override
    public Employee deleteEmployee(long id) {
        // TODO Auto-generated method stub
        Employee employee=employeeRepository.findById(id).get();
        employeeRepository.deleteById(id);
        
        return employee;
    }

    @Override
    public List<Employee> deleteAllEmployee() {
        // TODO Auto-generated method stub
        List<Employee> employees=employeeRepository.findAll();
        employeeRepository.deleteAll();

        return employees;
    }

    
}
