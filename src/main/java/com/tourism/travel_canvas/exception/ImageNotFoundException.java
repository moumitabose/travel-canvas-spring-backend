package com.tourism.travel_canvas.exception;



public class ImageNotFoundException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public ImageNotFoundException(String message) {
        super(message);
    }

    public ImageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
	
	
}


