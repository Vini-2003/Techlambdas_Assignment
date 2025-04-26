package com.demo.project1.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.project1.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String>
{
	
}
