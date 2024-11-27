package com.tourism.travel_canvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.repository.UserRepository;
import com.tourism.travel_canvas.service.UserService;
import com.tourism.travel_canvas.service.UserServiceImpl;

public class UserServiceTest {

	private UserRepository userRepository;
	private UserService userService;

	@BeforeEach
	void setup() {
		userRepository = Mockito.mock(UserRepository.class);
		userService = new UserServiceImpl(userRepository);
	}

//	@Test
//	void getAllUserDetails_test_success() {
//
//		List<User> userList=List.of(new User(1, "Moumita Bose", 1, "India", 1, LocalDateTime.now()),
//				new User(2, "Sumit Paul", 2, "India", 1, LocalDateTime.now()));
//		
//		when(userRepository.getAllUserDetails()).thenReturn(userList);
//		
//		List<User> result= userService.getAllUserDetails();
//		
//		assertEquals(userList, result,"both the results are same");
//		
//		verify(userRepository, times(1)).getAllUserDetails();
//	}

}
