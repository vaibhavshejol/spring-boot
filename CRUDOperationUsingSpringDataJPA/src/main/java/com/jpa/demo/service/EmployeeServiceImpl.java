package com.jpa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.dao.Repository;
import com.jpa.demo.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private Repository repository;
	

	@Override
	public Employee addEmployee(Employee employee) {
		Employee addEmployee = repository.save(employee);
		return addEmployee;
	}


	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return repository.save(employee);
	}


	@Override
	public boolean deleteEmployee(long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);;
		boolean result = repository.existsById(id);
		return result;
	}

}
