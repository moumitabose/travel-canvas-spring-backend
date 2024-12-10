package com.tourism.travel_canvas.service;

import java.text.ParseException;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.tourism.travel_canvas.model.Login;

public interface LoginService {
	
	public ResponseEntity<Map<String, Object>>   findLoginByUserId(Login login) throws ParseException;
	
	

}
