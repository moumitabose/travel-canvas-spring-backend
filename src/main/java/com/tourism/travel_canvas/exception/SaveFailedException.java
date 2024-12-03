package com.tourism.travel_canvas.exception;

public class SaveFailedException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public SaveFailedException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public SaveFailedException(String message) {
		super(message);

	}
	
	
}
