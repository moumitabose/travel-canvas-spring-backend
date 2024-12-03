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

public class LoginController {

	@Autowired
	private LoginServiceImpl loginservice;

	@PostMapping("/login")
	public ResponseEntity<Login> findLoginByUserId(@RequestBody Login login) {
		
		Login resultLogin = loginservice.findLoginByUserId(login);
		
		return ResponseEntity.ok(resultLogin);

	}

}
