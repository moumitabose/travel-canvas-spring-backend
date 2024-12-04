package com.tourism.travel_canvas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tourism.travel_canvas.model.Login;
import com.tourism.travel_canvas.service.LoginServiceImpl;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginServiceImpl loginservice;

	@PostMapping("/login")
	public ResponseEntity<Login> findLoginByUserId(@RequestBody Login login) {
		
		Login resultLogin = loginservice.findLoginByUserId(login);
		
		return ResponseEntity.ok(resultLogin);

	}

}
