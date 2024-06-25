package com.jpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.demo.entities.Employee;

public interface Repository extends JpaRepository<Employee, Long>{
	
}
