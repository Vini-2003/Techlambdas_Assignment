This project is a Spring Boot REST API application for managing employee records.
It uses MongoDB as the database and provides complete CRUD operations for Employee management.

Features:
    Create a new Employee
    Retrieve all Employees
    Retrieve an Employee by ID
    Update an existing Employee
    Delete an Employee

Technologies Used:
    Java 17+
    Spring Boot
    Spring Data MongoDB
    Lombok
    MongoDB

Project Structure:
Layer	Description:
        model/Employee	                 ->  Defines the Employee data structure.
        repository/EmployeeRepository	   ->  MongoRepository interface for DB operations.
        controller/EmployeeeController	 ->  REST API endpoints for managing employees.
        TechlambdasAssignmentApplication ->	 Main class to bootstrap the application.

API Endpoints:
Method	Endpoint	Description:
        GET	/api/employee	          ->   Fetch all employees
        GET	/api/employee/{id}	    ->   Fetch employee by ID
        POST	/api/employee         ->   Create a new employee
        PUT	/api/employee/{id}	    ->   Update an existing employee
        DELETE	/api/employee/{id}	->   Delete an employee
