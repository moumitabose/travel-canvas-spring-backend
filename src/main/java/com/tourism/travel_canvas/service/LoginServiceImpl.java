package com.tourism.travel_canvas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.Login;
import com.tourism.travel_canvas.repository.LoginRepository;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public Login login(Login login) {
		
		Login resultLogin = loginRepository.findLoginByUserId(login.getUsername());
		return resultLogin;
	}

//	@Override
//	public String login(Login login) {
//		
//		System.out.println("gdshgfhsfdh");
//
//		Login resultLogin = loginRepository.findLoginByUserId(login.getUsername());
//		
//		System.out.println("*&");
//
//		if (resultLogin != null && resultLogin.getPassword()
//				.equals(login.getPassword())) {
//			return JwtUtil.generateToken(login.getUsername());
////			return "SUCCESS";
//		}
//		throw new RuntimeException("Invalid credentials");
//		
//	}

//	    public String login(Login login) {
//	        Login login = loginRepository.findLoginByUserId(username);
//	        if (login != null && login.getPassword().equals(password)) {
//	            return JwtUtil.generateToken(username);
//	        }
//	        throw new RuntimeException("Invalid credentials");
//	    }

}
