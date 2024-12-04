package com.tourism.travel_canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.outputbean.RoleDetailsBasedOnUserBean;
import com.tourism.travel_canvas.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/getAllUserDetails")
	public List<RoleDetailsBasedOnUserBean> getAllUserDetails()
	{
		return userService.getAllUserDetails();
	}
	
	

}
