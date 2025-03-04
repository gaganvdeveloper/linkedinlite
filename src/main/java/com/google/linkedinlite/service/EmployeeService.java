package com.google.linkedinlite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.linkedinlite.dao.EmployeeDao;
import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.responsestructure.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseStructure<Employee> saveEmployee(Employee employee) {

		employee = dao.saveEmployee(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Employee Saved Successfully");
		structure.setBody(employee);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllEmployees() {
		List<Employee> emps = dao.findAllEmployees();
		if (emps.isEmpty()) {
			throw new RuntimeException("No Employee Found in the Database Table");
		}
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("All Employees Found Successfully");
		structure.setBody(emps);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllActiveEmployees() {
		List<Employee> emps = dao.findAllActiveEmployees();
		if (emps.isEmpty()) {
//			throw new NoEmployeeFoundException();
		}
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("All Employees Found Successfully");
		structure.setBody(emps);
		return structure;
	}

	public ResponseStructure<Employee> findEmployeeById(int id) {

		Optional<Employee> optional = dao.findEmployeeById(id);
		if (optional.isEmpty()) {
//			throw new InvalidEmployeeIdException();
		}
		Employee employee = optional.get();
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Employyee Found Successfully");
		structure.setBody(employee);
		return structure;
	}

}
