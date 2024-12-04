package com.tourism.travel_canvas.service;

import java.util.List;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.RoleDetailsBasedOnUserBean;

public interface UserService {
	
	public List<RoleDetailsBasedOnUserBean> getAllUserDetails();

}
