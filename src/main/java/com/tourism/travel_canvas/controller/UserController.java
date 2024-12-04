package com.tourism.travel_canvas.controller;

import java.io.IOException;
import java.util.List;

import com.tourism.travel_canvas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/getAllUserDetails")
	public List<AllDetailsBean> getAllUserDetails()
	{
		return userService.getAllUserDetails();
	}

	@PostMapping("/saveUserDetails")
	public ResponseEntity<User> saveUserDetails(@RequestBody User user) throws IOException
	{
		User resultUser= userService.saveUserDetails(user);

		return new ResponseEntity<>(resultUser, HttpStatus.CREATED);
	}
	
	

}
