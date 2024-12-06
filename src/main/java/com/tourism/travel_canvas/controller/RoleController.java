package com.tourism.travel_canvas.controller;

import java.io.IOException;
import java.util.List;

import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.Role;
import com.tourism.travel_canvas.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/getAllRoles")
	public ResponseEntity<List<Role>> getAllRoles() {
		List<Role> resultRoleList = roleService.getAllRoles();
		return ResponseEntity.ok(resultRoleList);
	}

	@GetMapping("/getAllRoleDetails")
	public ResponseEntity<List<AllDetailsBean>> getAllRoleDetails() {
		List<AllDetailsBean> roleFinalList = roleService.getAllRoleDetails();
		return ResponseEntity.ok(roleFinalList);

	}

	@PostMapping("/getRoleDetailsByRoleId")
	public ResponseEntity<Role> getRoleDetailsByRoleId(@RequestBody Role role) {
		if (role == null || role.getRoleid() == null) {
			return ResponseEntity.badRequest().build(); // 400 Bad Request if roleId is missing
		}
		Role resultRole = roleService.getRoleDetailsByRoleId(role);
		return ResponseEntity.ok(resultRole); // 200 OK with role details
	}

	@PostMapping("/getAllRolesByRoleName")
	public ResponseEntity<List<Role>> getAllRolesByRoleName(@RequestBody Role role) {
		if (role == null || role.getRoleid() == null) {
			return ResponseEntity.badRequest().build(); // 400 Bad Request if roleId is missing
		}
		List<Role> resultRoleList = roleService.getAllRolesByRoleName(role);
		return ResponseEntity.ok(resultRoleList); // 200 OK with role details
	}

	@PostMapping("/saveRoledetails")
	public ResponseEntity<Role> saveRoledetails(@RequestBody Role role) throws IOException {

		Role saveRoleDetails = roleService.saveRoledetails(role);
		return new ResponseEntity<>(saveRoleDetails, HttpStatus.CREATED);
	}

//	@PostMapping("/updateRoledetails")
//	public ResponseEntity<Role> updateRoledetails(@RequestBody Role role) throws IOException {
//
//		Role updateRoleDetails = roleService.updateRoledetails(role);
//		return new ResponseEntity<>(updateRoleDetails, HttpStatus.CREATED);
//	}
//
//	@PostMapping("/deleteRoledetails")
//	public ResponseEntity<Role> deleteRoledetails(@RequestBody Role role) throws IOException {
//
//		Role deleteRoledetails = roleService.deleteRoledetails(role);
//		return new ResponseEntity<>(deleteRoledetails, HttpStatus.CREATED);
//	}

}
