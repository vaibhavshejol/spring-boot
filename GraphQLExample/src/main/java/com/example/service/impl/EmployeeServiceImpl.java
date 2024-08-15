package com.example.service.impl;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
        return true;
    }
}
