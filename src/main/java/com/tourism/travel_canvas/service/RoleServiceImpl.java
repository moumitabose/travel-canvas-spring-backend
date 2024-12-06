package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tourism.travel_canvas.model.User;

import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.exception.DeleteFailedException;
import com.tourism.travel_canvas.exception.RoleNotFoundException;
import com.tourism.travel_canvas.exception.SaveFailedException;
import com.tourism.travel_canvas.exception.UpdateFailedException;
import com.tourism.travel_canvas.model.Role;
import com.tourism.travel_canvas.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	public RoleServiceImpl(RoleRepository roleRepository) {

		this.roleRepository = roleRepository;
	}
	
	public RoleServiceImpl(RoleRepository roleRepository,UserRepository userRepository)
	{
		this.roleRepository = roleRepository;
		this.userRepository=userRepository;
	}

	@Override
	public List<Role> getAllRoles() {

		List<Role> resultRoleList = roleRepository.getAllRoles();

		if (resultRoleList.size() == 0) {
			throw new RoleNotFoundException("Empty List Of Role");
		}

		return resultRoleList;
	}

	@Override
	public List<AllDetailsBean> getAllRoleDetails() {

		List<Role> resultRoleList = roleRepository.getAllRoles();

		if (resultRoleList.size() == 0) {
			throw new RoleNotFoundException("Empty List Of Role");
		} else {
			List<AllDetailsBean> roleFinalList = new ArrayList<AllDetailsBean>();

			resultRoleList.forEach(role -> {
				AllDetailsBean roleDetails = new AllDetailsBean();

				roleDetails.setRoleid(role.getRoleid());
				roleDetails.setRolename(role.getRolename());
				roleDetails.setActiveflag(role.getActiveflag());
				roleDetails.setCreateby(role.getCreateby());

				User user = userRepository.geUserDetailsByuserid(role.getCreateby());

				if (user != null) {
					roleDetails.setCreatename(user.getName());
				}

				roleDetails.setCreatename(user.getName());

				roleDetails.setCreatedt(role.getCreatedt());

				roleDetails.setModby(role.getModby());

				if (role.getModby() != null) {
					User usermodby = userRepository.geUserDetailsByuserid(role.getModby());
					if (usermodby != null) {

						roleDetails.setModname(usermodby.getName());
					}
				}

				roleDetails.setModdt(role.getModdt());

				roleFinalList.add(roleDetails);

			});

			return roleFinalList;
		}

	}

	@Override
	public Role getRoleDetailsByRoleId(Role role) {

		Role resultRole = roleRepository.getRoleDetailsByRoleId(role.getRoleid());

		if (resultRole == null) {
			throw new RoleNotFoundException("Role not found with Role ID: " + role.getRoleid());
		}

		return resultRole;
	}

	@Override
	public List<Role> getAllRolesByRoleName(Role role) {

		List<Role> resultRoleList = roleRepository.getAllRolesByRoleName(role.getRolename());

		if (resultRoleList == null || resultRoleList.isEmpty()) {
			throw new RoleNotFoundException("Empty List Of Role with this Role Name: " + role.getRolename());
		}

		return resultRoleList;

	}

	@Override
	public Role saveRoledetails(Role role) throws IOException {

		Role savedRole = roleRepository.save(role);

		if (savedRole == null) {
			throw new SaveFailedException("Failed to save role");
		}

		return savedRole;

	}

//
//	@Override
//	public Role updateRoledetails(Role role) throws IOException {
//
//		boolean duplicateRoleNameFlag = roleRepository.getAllRoles().stream()
//				.anyMatch(r -> r.getRolename().equalsIgnoreCase(role.getRolename()));
//
//		if (!duplicateRoleNameFlag) {
//
//			Role existingRole = roleRepository.updateRoledetails(role.getRolename(), role.getModdt(), role.getModby(),
//					role.getRoleid());
//
//			return existingRole;
//
//		} else {
//			throw new UpdateFailedException("Role name already exists, update not possible");
//		}
//	}
//
//	@Override
//	public Role deleteRoledetails(Role role) throws IOException {
//
//		Role roleToBeDelete = roleRepository.deleteRoledetails(role.getModdt(), role.getModby(), role.getRoleid());
//
//		if (roleToBeDelete == null) {
//			throw new DeleteFailedException("Delete operation failed for role");
//		}
//
//		return roleToBeDelete;
//
//	}

}
