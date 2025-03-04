package com.google.linkedinlite.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.linkedinlite.dao.EducationDao;
import com.google.linkedinlite.dao.EmployeeDao;
import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.entity.Employee;
import com.google.linkedinlite.responsestructure.ResponseStructure;
import com.google.linkedinlite.util.EducationStatus;

@Service
public class EducationService {

	@Autowired
	private EducationDao educationDao;

	@Autowired
	private EmployeeDao employeeDao;

	public ResponseStructure<Education> saveEducation(Education education, int eid) {
		Optional<Employee> optional = employeeDao.findEmployeeById(eid);
		if (optional.isEmpty()) {
			// throw new InvalidEmployeeIdException();
		}
		Employee employee = optional.get();

		education.setEmployee(employee);

		education = educationDao.saveEducation(education);
		ResponseStructure<Education> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Education Saved Successfully");
		structure.setBody(education);
		return structure;
	}

	public ResponseStructure<List<Education>> findAllEducationsByEmployeeId(int eid) {
		List<Education> el = educationDao.findAllEducations();
		if (el.isEmpty()) {
//			throw new NoEducationFoundException();
		}
		ArrayList<Education> fel = new ArrayList<>();
		for (Education edu : el) {
			Employee emp = edu.getEmployee();
			if (emp.getId() == eid) {
				fel.add(edu);
			}
		}
		if (fel.isEmpty()) {
//			throw new NoEducationFoundException();
		}
		ResponseStructure<List<Education>> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("All Educations Found Successfully from Employee Id : " + eid);
		structure.setBody(fel);
		return structure;
	}

	public ResponseStructure<Education> setStatusToInactive(int id) {

		Optional<Education> optional = educationDao.findEducationById(id);
		
		if (optional.isEmpty()) {
//			throw new InvalidEducationIdException();
		}

		Education education = optional.get();
		education.setStatus(EducationStatus.IN_ACTIVE);
		education = educationDao.saveEducation(education);

		ResponseStructure<Education> structure = new ResponseStructure<>();
		structure.setStatus(200);
		structure.setMessage("Education Status Updated to IN_ACTIVE successfully...");
		structure.setBody(education);
		
		return structure;
	}

}
