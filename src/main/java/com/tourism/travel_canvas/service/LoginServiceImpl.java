package com.tourism.travel_canvas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.exception.LoginFailedException;
import com.tourism.travel_canvas.model.Login;
import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.repository.LoginRepository;
import com.tourism.travel_canvas.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired

	private LoginRepository loginRepository;
	private UserRepository userRepository;

	public LoginServiceImpl() {

	}

	@Autowired
	public LoginServiceImpl(LoginRepository loginRepository, UserRepository userRepository) {
		this.loginRepository = loginRepository;
		this.userRepository = userRepository;
	}

	@Override
	public ResponseEntity<Map<String, Object>> findLoginByUserId(Login login) throws ParseException {

		Login resultLogin = loginRepository.findLoginByUserId(login.getUsername(), login.getPassword());

		Map<String, Object> data = new HashMap<>();

		if (resultLogin == null) {
			throw new LoginFailedException("Login not possible with this credintials");
		}

		else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date today = sdf.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

			long daysDifference = (resultLogin.getTodt().getTime() - today.getTime()) / (1000 * 60 * 60 * 24);

			User user = userRepository.geUserDetailsByuserid(resultLogin.getUser().getUserid());

			if (daysDifference > 0 && resultLogin.getActiveflag() == 'Y') {

				data.put("name", user.getUsername());

				if (user.getRole().getRolename().equalsIgnoreCase("ADMIN")
						|| user.getRole().getRolename().equalsIgnoreCase("MODERATOR"))

//				if(user.getRole().getRoleid()==1 || 
//						user.getRole().getRoleid()==2  )
				{
					data.put("role", user.getRole().getRolename());

					// data.put("role", user.getRole().getRoleid());
				} else if (user.getRole().getRolename().equalsIgnoreCase("USER"))
//					else if(user.getRole().getRoleid()==3  )
				{
					data.put("role", user.getRole().getRolename());

					// data.put("role", user.getRole().getRoleid());
				} else {
					throw new LoginFailedException("Invalid role");
				}

				Map<String, Object> response = new HashMap<>();
				response.put("status", "success");
				response.put("data", data);

				return ResponseEntity.ok(response);
			} else {
				throw new LoginFailedException("Login not possible: account expired or inactive");
			}

		}

	}

}
