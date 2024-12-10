package com.tourism.travel_canvas.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler({
	        RoleNotFoundException.class,
	        CountryNotFoundException.class,
	        ImageNotFoundException.class,
	        PackageListNotFoundException.class
	    })
	    public ResponseEntity<Map<String, Object>> handleNotFoundExceptions(RuntimeException e) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", "error");
	        response.put("message", e.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	    }

	    @ExceptionHandler(LoginFailedException.class)
	    public ResponseEntity<Map<String, Object>> handleLoginFailedException(LoginFailedException e) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", "error");
	        response.put("message", e.getMessage());
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }

	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGenericException(Exception e) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("status", "error");
	        response.put("message", "An error occurred: " + e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	    }

	    @ExceptionHandler({
	        SaveFailedException.class,
	        UpdateFailedException.class,
	        DeleteFailedException.class
	    })
	    public ResponseEntity<String> handleServerSideExceptions(RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    }



}
