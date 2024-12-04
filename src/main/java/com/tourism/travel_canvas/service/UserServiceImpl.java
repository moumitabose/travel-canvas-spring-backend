package com.tourism.travel_canvas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.RoleDetailsBasedOnUser;
import com.tourism.travel_canvas.outputbean.RoleDetailsBasedOnUserBean;
import com.tourism.travel_canvas.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<RoleDetailsBasedOnUserBean> getAllUserDetails() {

		List<RoleDetailsBasedOnUser> roleDetailsBasedOnUser = userRepository.getAllUserDetails();

		List<RoleDetailsBasedOnUserBean> roleFinalList = new ArrayList<RoleDetailsBasedOnUserBean>();

		roleDetailsBasedOnUser.forEach(role -> {
			RoleDetailsBasedOnUserBean roleDetails = new RoleDetailsBasedOnUserBean();

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

}
