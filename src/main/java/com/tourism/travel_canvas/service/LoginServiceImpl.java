package com.tourism.travel_canvas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.exception.LoginFailedException;
import com.tourism.travel_canvas.model.Login;
import com.tourism.travel_canvas.repository.LoginRepository;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login findLoginByUserId(Login login) {
		
		
		
		Login resultLogin = loginRepository.findLoginByUserId(login.getUsername(),login.getPassword());
		if(resultLogin==null)
		{
			throw new LoginFailedException("Login not possible with this credintials");
		}
		return resultLogin;
	}



}
