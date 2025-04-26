package com.demo.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project1.Repository.EmployeeRepository;
import com.demo.project1.model.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employees
	@GetMapping
	public List<Employee> getEmployees()
	{			
		return employeeRepository.findAll();
	}
	
	//get a employee by id
	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable String id)
	{
		return employeeRepository.findById(id);
				
	}
	
	//create an employee 
	@PostMapping 
	public Employee createEmployee(@RequestBody Employee emp) {
		return employeeRepository.save(emp);			
	}
	
	//update an employee
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmp) {
	    Optional<Employee> existingEmployee = employeeRepository.findById(id);
	    
	    if (existingEmployee.isPresent()) {
	        Employee existingEmp = existingEmployee.get();
	        
	        existingEmp.setEmployeeId(updatedEmp.getEmployeeId());
	        existingEmp.setEmployeeName(updatedEmp.getEmployeeName());
	        existingEmp.setGender(updatedEmp.getGender());
	        existingEmp.setDesignation(updatedEmp.getDesignation());
	        existingEmp.setEmailId(updatedEmp.getEmailId());
	        existingEmp.setMobileNumber(updatedEmp.getMobileNumber());
	        existingEmp.setDateOfBirth(updatedEmp.getDateOfBirth());
	        existingEmp.setCity(updatedEmp.getCity());
	        existingEmp.setAddress(updatedEmp.getAddress());

	        Employee savedEmployee = employeeRepository.save(existingEmp);
	        return ResponseEntity.ok(savedEmployee);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	//delete an employee
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable String id)
	{
		Employee Employeedata= employeeRepository.findById(id).orElse(null);
		employeeRepository.delete(Employeedata);
		return ResponseEntity.ok().build();
	}
}
