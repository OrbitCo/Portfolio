package com.portfolio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlanNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 605354536802191604L;
	
	public PlanNotFoundException(String exception) {
		super(exception);
	}
	
	

}
