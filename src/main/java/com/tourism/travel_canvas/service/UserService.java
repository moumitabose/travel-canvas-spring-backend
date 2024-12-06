package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;

public interface UserService {
	
	public List<AllDetailsBean> getAllUserDetails();

	public User saveUserDetails(User user) throws IOException;

}
