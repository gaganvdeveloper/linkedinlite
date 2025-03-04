package com.google.linkedinlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.google.linkedinlite.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query("select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployees();

}
