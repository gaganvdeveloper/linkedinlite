package com.google.linkedinlite.exceptionhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.linkedinlite.responsestructure.ResponseStructure;

@RestControllerAdvice
public class EmployeeExceptionHandler {
	

	@ExceptionHandler(RuntimeException.class)
	public ResponseStructure<String> runtimeExceptionHandler(RuntimeException e){
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setStatus(404);
		structure.setMessage("No Employee Present int the Database Table");
		structure.setBody(e.getMessage());
		return structure;
	}
	
	
}
