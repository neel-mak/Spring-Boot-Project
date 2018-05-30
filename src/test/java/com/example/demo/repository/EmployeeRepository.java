package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	
	public List<Employee> findByEmployeeName(String name);
}
