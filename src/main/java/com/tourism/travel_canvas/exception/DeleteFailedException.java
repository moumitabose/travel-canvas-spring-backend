package com.tourism.travel_canvas.exception;

public class DeleteFailedException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public DeleteFailedException(String message, Throwable cause) {
		super(message, cause);

	}

	public DeleteFailedException(String message) {
		super(message);
		
	}
	
	

}
