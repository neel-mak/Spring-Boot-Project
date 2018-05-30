package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.Employee;
import com.example.demo.services.EmployeeService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(path="/employee",method=RequestMethod.GET)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @RequestMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable String id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping(method = RequestMethod.POST,path ="/employee")
    public void addEmployee(@RequestBody Employee employee){
    	employeeService.addEmployee(employee);
    }

    @RequestMapping(method = RequestMethod.PUT,path ="/employee/{id}")
    public void updateEmployee(@RequestBody Employee em,@PathVariable String id){
    	employeeService.updateEmployee(id, em);
    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/employee/{id}")
    public void deleteEmployee(@PathVariable String id){
    	employeeService.deleteEmployee(id);
    }
}
