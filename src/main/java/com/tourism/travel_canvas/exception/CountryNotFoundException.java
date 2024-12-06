package com.tourism.travel_canvas.exception;

public class CountryNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public CountryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public CountryNotFoundException(String message) {
		super(message);

	} 
	
	

}
