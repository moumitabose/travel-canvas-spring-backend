package com.tourism.travel_canvas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LoginFailedException.class)
	 public ResponseEntity<String> handleLoginFailedException(LoginFailedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<String> handleRoleNotFoundException(RoleNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	@ExceptionHandler(CountryNotFoundException.class)
	public ResponseEntity<String> CountryNotFoundException(CountryNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	

	@ExceptionHandler(ImageNotFoundException.class)
	public ResponseEntity<String> handleImageNotFoundException(ImageNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(PackageListNotFoundException.class)
	public ResponseEntity<String> handlePackageListNotFoundException(PackageListNotFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}

	@ExceptionHandler(SaveFailedException.class)
	public ResponseEntity<String> handleSaveFailedException(SaveFailedException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(UpdateFailedException.class)
	public ResponseEntity<String> handleUpdateFailedException(UpdateFailedException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DeleteFailedException.class)
	public ResponseEntity<String> handleDeleteFailedException(DeleteFailedException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
	}

}
