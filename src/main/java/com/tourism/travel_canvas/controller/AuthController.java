package com.tourism.travel_canvas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.Login;
import com.tourism.travel_canvas.service.LoginServiceImpl;

@RestController

public class AuthController {
	
	 @Autowired
	    private LoginServiceImpl loginservice;

//	    @PostMapping("/login")
//	    public ResponseEntity<Map<String, String>> login(@RequestBody Login login) {
//	    	
//	    	String token = loginservice.login(login);
//	        Map<String, String> response = new HashMap<>();
//	        response.put("token", token);
//	        return ResponseEntity.ok(response); 
////	        return loginservice.login(login);
//	    }
	 
	 
	 @PostMapping("/login")
	    public ResponseEntity<Map<String, String>> login(@RequestBody Login login) {
	        // Simulate authentication and JWT generation
	        String token = "sample_jwt_token_for_" + login.getUsername();

	        // Add the token to the response body
	        Map<String, String> response = new HashMap<>();
	        response.put("token", token);

	        return ResponseEntity.ok(response);  // Return the response body as JSON
	    }
	 
	 
//	 @PostMapping("/loginF")
//	 public Login login(@RequestBody Login login) {
//		 return loginservice.login(login);
//	 }
	    
	    
	    @GetMapping("/test")
	    public String test() {
	        return "moumita";
	    }

}
