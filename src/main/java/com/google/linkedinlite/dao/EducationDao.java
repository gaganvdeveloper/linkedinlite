package com.google.linkedinlite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.linkedinlite.entity.Education;
import com.google.linkedinlite.repository.EducationRepository;
@Repository
public class EducationDao {
	
	@Autowired
	private EducationRepository repository;

	public Education saveEducation(Education education) {
		return repository.save(education);
	}

	public List<Education> findAllEducations() {
		return repository.findAll();
	}

	public Optional<Education> findEducationById(int id) {
		return repository.findById(id);
	}
	
	
	
	
}
