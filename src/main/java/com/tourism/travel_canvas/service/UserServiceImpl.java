package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tourism.travel_canvas.exception.SaveFailedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.AllDetails;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<AllDetailsBean> getAllUserDetails() {

		List<AllDetails> roleDetailsBasedOnUser = userRepository.getAllUserDetails();

		List<AllDetailsBean> roleFinalList = new ArrayList<AllDetailsBean>();

		roleDetailsBasedOnUser.forEach(role -> {
			AllDetailsBean roleDetails = new AllDetailsBean();

			roleDetails.setUserid(role.getUserid());
			roleDetails.setName(role.getName());
			roleDetails.setCountryid(role.getCountryid());
			roleDetails.setCountryname(role.getCountryname());
			roleDetails.setEmail(role.getEmail());
			roleDetails.setActiveflag(role.getActiveflag());
			roleDetails.setCreateby(role.getCreateby());

			User user = userRepository.geUserDetailsByuserid(role.getCreateby());

			roleDetails.setCreatename(user.getName());

			roleDetails.setCreatedt(role.getCreatedt());

			roleDetails.setModby(role.getModby());

			User usermodby = userRepository.geUserDetailsByuserid(role.getCreateby());

			roleDetails.setModname(usermodby.getName());

			roleDetails.setModdt(role.getModdt());

			roleFinalList.add(roleDetails);

		});

		return roleFinalList;
	}

	@Override
	public User saveUserDetails(User user) throws IOException {
		 User resultUser= userRepository.save(user);

		 if(resultUser==null)
		 {
			 throw new SaveFailedException("Failed to save user");
		 }
		 return resultUser;
	}

}
