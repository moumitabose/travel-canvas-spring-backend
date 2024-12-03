package com.tourism.travel_canvas.exception;

public class PackageListNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public PackageListNotFoundException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public PackageListNotFoundException(String message) {
		super(message);
		
	}
	
	
	

}
