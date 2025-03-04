package com.google.linkedinlite.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import com.google.linkedinlite.Experience;
import com.google.linkedinlite.util.EmployeeStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@CreationTimestamp
	private LocalDate dateOfJoin;
	private String email;
	private double salary;
	private long phone;
	private String password;
	@Enumerated(EnumType.STRING)
	private Experience experience = Experience.FRESHER; // enum ----> EXPERIENCED || FRESHER
	@Enumerated(EnumType.STRING)
	private EmployeeStatus status = EmployeeStatus.ACTIVE; // enum ----> ACTIVE || IN_ACTIVE || BLOCKED ||
}

// POST			-->			/employees			json Obj employee { data }	-->	save an employee
//	
// GET			-->			/employees				(ACTIVE)				--> fetch all employees
//
// GET 			-->			/employees/{eid}								--> fetch an employee by id
//
// POST			-->			/employees/login	json Obj login {  }			--> login verification by email and password
// 
// PATCH		-->			/employees/status/{eid}/{status}				--> change the status of the employee by id