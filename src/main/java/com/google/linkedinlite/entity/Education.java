package com.google.linkedinlite.entity;

import com.google.linkedinlite.util.EducationStatus;
import com.google.linkedinlite.util.HeighestQualification;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Education {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
	private String universityName;
	private double percentage;
	private int completionYear;
	@Enumerated(EnumType.STRING)
	private HeighestQualification heighestQualification=HeighestQualification.YES; // enum ----> YES || NO
	@Enumerated(EnumType.STRING)
	private EducationStatus status = EducationStatus.ACTIVE;// enum ----> ACTIVE || IN_ACTIVE 
	@ManyToOne
	private Employee employee;
}
