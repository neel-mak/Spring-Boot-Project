package com.example.demo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/*private List<Employee> list= new ArrayList<>(Arrays.asList(
			new Employee(01,"Neel Patel","abc@gmail.com"),
			new Employee(02,"Aditya parmar","def@gmail.com"),
			new Employee(03,"Pranav Borasiya","swt@gmail.com")));
	*/
	public List<Employee> getAllEmployee(){
		
		List<Employee> emp=new ArrayList<>();
		employeeRepository.findAll().forEach(emp::add);
		return emp;
		
	}
	
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(int id, Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
