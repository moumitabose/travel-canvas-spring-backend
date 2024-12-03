package com.tourism.travel_canvas.exception;

public class LoginFailedException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public LoginFailedException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public LoginFailedException(String message) {
		super(message);
	
	}
	
	


}
