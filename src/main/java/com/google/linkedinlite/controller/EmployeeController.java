package com.google.linkedinlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.responsestructure.ResponseStructure;
import com.google.linkedinlite.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

//	@Operation(summary = "To Save an Employee", description = "This API is used to save an Employee Object, this API Accepts the Request Body of Employee Object which should contains the fields as fallows : firstName, lastName, email, phone, password and salary in the requested JSON Object Object and it sholudn't have id field in it, if id present it performs update operation, if id not their means it performs save operation  ")

	@PostMapping
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

//	@Operation(summary = "To Fetch All Employees", description = "This API is used to fetch All the Employees from the Database Table")
//	@ApiResponses(value = {@ApiResponse(responseCode = "200",description = "Found All Employees"), @ApiResponse(responseCode = "404", description = "No Employees Present in the Database Table")})
	@GetMapping
	public ResponseStructure<List<Employee>> findAllEmployees() {
		return service.findAllEmployees();
	}

	@Operation(summary = "To Fetch All ACTIVE Employees")

	@GetMapping("/status/active")
	public ResponseStructure<List<Employee>> findAllActiveEmployees() {
		return service.findAllActiveEmployees();
	}

//	@Operation(summary = "To Fetch An Employee by Id")

	@GetMapping("/{id}")
	public ResponseStructure<Employee> findEmployeeById(@PathVariable int id) {
		return service.findEmployeeById(id);
	}

}
