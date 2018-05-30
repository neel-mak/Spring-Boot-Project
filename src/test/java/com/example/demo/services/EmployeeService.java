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
	
	private List<Employee> list= new ArrayList<>(Arrays.asList(
			new Employee("01","Neel Patel","abc@gmail.com"),
			new Employee("02","Aditya parmar","def@gmail.com"),
			new Employee("03","Pranav Borasiya","swt@gmail.com")));
	
	public List<Employee> getAllEmployee(){
		System.out.println("Under to avyu 6e.");
		return list;
	}
	
	public Employee getEmployee(String str) {
		return list.stream().filter(t->t.getEmployeeId().equals(str)).findFirst().get();
	}
	
	public void addEmployee(Employee employee) {
		list.add(employee);
	}
	
	public void updateEmployee(String id, Employee employee) {
        for(int i=0;i<list.size();i++){
            Employee a=list.get(i);
            if(a.getEmployeeId().equals(id)){
                list.set(i,a);
                return;
            }
        }
    }

    public void deleteEmployee(String id) {
        list.removeIf(t->t.getEmployeeId().equals(id));
    }
}
