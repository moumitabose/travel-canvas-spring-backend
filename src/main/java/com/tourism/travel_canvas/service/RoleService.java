package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;


import com.tourism.travel_canvas.model.Role;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;

public interface RoleService {
	
	public List<Role> getAllRoles();

	public List<AllDetailsBean> getAllRoleDetails();

	public Role getRoleDetailsByRoleId(Role role);

	public List<Role> getAllRolesByRoleName(Role role);

	public Role saveRoledetails(Role role) throws IOException;

	public void updateRoledetails(Role role) throws IOException;

	//public Role deleteRoledetails(Role role) throws IOException;



}
