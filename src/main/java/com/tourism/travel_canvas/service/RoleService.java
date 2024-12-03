package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;


import com.tourism.travel_canvas.model.Role;

public interface RoleService {
	
	public List<Role> getAllRoles();
	
	public Role getRoleDetailsByRoleId(Role role);
	
	public List<Role> getAllRolesByRoleName(Role role);
	
	public Role saveRoledetails(Role role) throws IOException;
	
	public Role updateRoledetails(Role role) throws IOException;
	
	public Role deleteRoledetails(Role role) throws IOException;

}
