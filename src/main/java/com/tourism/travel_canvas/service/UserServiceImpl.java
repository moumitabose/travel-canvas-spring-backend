package com.tourism.travel_canvas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}



	@Override
	public List<User> getAllUserDetails() {

		try {
			return List.copyOf(userRepository.getAllUserDetails());
		}

		catch (Exception e) {
			System.err.println("Failed to fetch users: " + e.getMessage());
			return List.of(); // Returns an immutable empty list
		}

	}

}
