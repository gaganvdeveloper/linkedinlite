package com.google.linkedinlite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.responsestructure.ResponseStructure;
import com.google.linkedinlite.service.EducationService;
@RestController
@RequestMapping("/educations")
public class EducationController {

	@Autowired
	private EducationService service;
	
	
	@PostMapping("/{eid}")
	public ResponseStructure<Education> saveEducation(@RequestBody Education education, @PathVariable int eid){
		return service.saveEducation(education,eid);
	}
	
	@GetMapping("/employee/{eid}")
	public ResponseStructure<List<Education>> findAllEducationsByEmployeeId(@PathVariable int eid){
		return service.findAllEducationsByEmployeeId(eid);
	}
	
	@PatchMapping("/status/inactive/{id}")
	public ResponseStructure<Education> setStatusToInactive(@PathVariable int id){
		return service.setStatusToInactive(id);
	}
	
	
}
