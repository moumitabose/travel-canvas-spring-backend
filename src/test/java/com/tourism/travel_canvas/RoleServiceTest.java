package com.tourism.travel_canvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tourism.travel_canvas.exception.DeleteFailedException;
import com.tourism.travel_canvas.exception.RoleNotFoundException;
import com.tourism.travel_canvas.exception.SaveFailedException;
import com.tourism.travel_canvas.exception.UpdateFailedException;
import com.tourism.travel_canvas.model.Role;
import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.repository.RoleRepository;
import com.tourism.travel_canvas.repository.UserRepository;
import com.tourism.travel_canvas.service.RoleService;
import com.tourism.travel_canvas.service.RoleServiceImpl;

public class RoleServiceTest {

	private RoleRepository roleRepository;
	private RoleService roleService;
	private UserRepository userRepository;

	private Role role;

	private Role existingRoleForUpdate;

//	@BeforeEach
//	void setup() {
//		roleRepository = Mockito.mock(RoleRepository.class);
//		roleService = new RoleServiceImpl(roleRepository);
//
//		userRepository = Mockito.mock(UserRepository.class);
//
//		role = new Role(1, "Admin", 'Y', 1, LocalDateTime.now());
//
//		existingRoleForUpdate = new Role();
//
//		existingRoleForUpdate.setRoleid(1);
//		existingRoleForUpdate.setRolename("Admin");
//		existingRoleForUpdate.setModby(2);
//		existingRoleForUpdate.setModdt(LocalDateTime.now());
//	}
//
//	@Test
//	void getAllRoles_test() {
//		List<Role> roleList = List.of(new Role(1, "Admin", 'Y', 1, LocalDateTime.now()),
//				new Role(2, "User", 'Y', 1, LocalDateTime.now()));
//
//		when(roleRepository.getAllRoles()).thenReturn(roleList);
//
//		List<Role> resultRoleList = roleService.getAllRoles();
//
//		assertEquals(roleList.size(), resultRoleList.size(), "both role list are in equal size");
//
//		verify(roleRepository, times(1)).getAllRoles();
//
//	}
//
//	@Test
//	void getAllRoles_empty_test() {
//
//		when(roleRepository.getAllRoles()).thenReturn(null);
//
//		RoleNotFoundException roleNotFoundException = assertThrows(RoleNotFoundException.class, () -> {
//			roleService.getAllRoles();
//		});
//
//		assertEquals("Role list not found ", roleNotFoundException.getMessage());
//
//		verify(roleRepository, times(1)).getAllRoles();
//	}
//
//	@Test
//	void getAllRoleDetails_test() {
//		List<Role> roleList = List.of(new Role(1, "Admin", 'Y', 101, LocalDateTime.now(), 102, LocalDateTime.now()));
//
//		User userone = new User(101, "Moumita");
//		User usertwo = new User(102, "Sumit");
//
//		when(userRepository.geUserDetailsByuserid(101)).thenReturn(userone);
//		when(userRepository.geUserDetailsByuserid(102)).thenReturn(usertwo);
//
//		List<AllDetailsBean> result = roleService.getAllRoleDetails();
//
//		assertNotNull(result);
//
//		assertEquals(result.size(), roleList.size());
//
//		AllDetailsBean roleDetails = result.get(0);
//
//		assertEquals(1, roleDetails.getRoleid());
//		assertEquals("Admin", roleDetails.getRolename());
//		assertEquals("Moumita", roleDetails.getCreatename());
//		assertEquals("Sumit", roleDetails.getModname());
//
//	}
//
//	@Test
//	void getRoleDetailsByRoleId_test() {
//
//		when(roleRepository.getRoleDetailsByRoleId(1)).thenReturn(role);
//
//		Role resultrole = roleService.getRoleDetailsByRoleId(role);
//
//		assertEquals(role.getRolename(), resultrole.getRolename(), "Returned role should match the role name");
//
//		// Verify repository interaction
//		verify(roleRepository, times(1)).getRoleDetailsByRoleId(1);
//	}
//
//	@Test
//	void getRoleDetailsByRoleId_Not_Found_test() {
//
//		when(roleRepository.getRoleDetailsByRoleId(1)).thenReturn(null);
//
//		RoleNotFoundException roleNotFoundException = assertThrows(RoleNotFoundException.class, () -> {
//			roleService.getRoleDetailsByRoleId(role);
//		});
//
//		assertEquals("Role not found with this Role ID : 1", roleNotFoundException.getMessage());
//
//		// Verify repository interaction
//		verify(roleRepository, times(1)).getRoleDetailsByRoleId(1);
//	}
//
//	@Test
//	void getAllRolesByRoleName_test() {
//		List<Role> roleList = List.of(new Role(1, "Admin", 'Y', 1, LocalDateTime.now()),
//				new Role(2, "Admin", 'Y', 1, LocalDateTime.now()));
//
//		when(roleRepository.getAllRolesByRoleName("Admin")).thenReturn(roleList);
//
//		List<Role> resultRoleList = roleService.getAllRolesByRoleName(role);
//
//		assertNotNull(resultRoleList);
//
//		assertEquals(roleList.size(), resultRoleList.size(), "Returned role list should match the given role list ");
//	}
//
//	@Test
//	void getAllRolesByRoleName_Not_Found_test() {
//		when(roleRepository.getAllRolesByRoleName("Admin")).thenReturn(null);
//
//		RoleNotFoundException roleNotFoundException = assertThrows(RoleNotFoundException.class, () -> {
//			roleService.getAllRolesByRoleName(role);
//
//		});
//
//		assertEquals("Empty List Of Role with this Role Name: ", roleNotFoundException.getMessage());
//	}
//
//	@Test
//	void saveRoledetails_test() throws IOException {
//		Role saved = new Role(1, "Admin", 'Y', 1, LocalDateTime.now());
//
//		when(roleRepository.save(role)).thenReturn(saved);
//
//		Role resultRole = roleService.saveRoledetails(role);
//
//		assertEquals(saved, resultRole, "The saved role should match the expected role.");
//
//		verify(roleRepository, times(1)).save(role);
//	}
//
//	@Test
//	void saveRoledetails_empty_test() throws IOException {
//
//		when(roleRepository.save(role)).thenReturn(null);
//
//		SaveFailedException saveFailedException = assertThrows(SaveFailedException.class, () -> {
//			roleService.saveRoledetails(role);
//		});
//
//		assertEquals("Failed to save role", saveFailedException.getMessage());
//
//		verify(roleRepository, times(1)).save(role);
//
//	}

//	@Test
//	void updateRoledetails_test() throws IOException {
//
//		when(roleRepository.getAllRoles()).thenReturn(Arrays.asList(existingRoleForUpdate)); // No duplicate role name
//		when(roleRepository.updateRoledetails(existingRoleForUpdate.getRolename(), existingRoleForUpdate.getModdt(),
//				existingRoleForUpdate.getModby(), existingRoleForUpdate.getRoleid())).thenReturn(role);
//
//		// Act
//		Role updatedRole = roleService.updateRoledetails(role);
//
//		// Assert
//		assertNotNull(updatedRole);
//		assertEquals("Admin", updatedRole.getRolename());
//		verify(roleRepository, times(1)).save(existingRoleForUpdate);
//	}

//	@Test
//	void updateRoledetails_test_WhenRoleNameIsDuplicate() {
//		// Arrange
//		Role duplicateRole = new Role();
//		duplicateRole.setRolename("Admin");
//		when(roleRepository.getAllRoles()).thenReturn(Arrays.asList(duplicateRole)); // Duplicate role name
//
//		// Act & Assert
//		assertThrows(UpdateFailedException.class, () -> roleService.updateRoledetails(role));
//
//	}
//
//	@Test
//	void deleteRoledetails_test() throws IOException {
//		when(roleRepository.deleteRoledetails(existingRoleForUpdate.getModdt(), existingRoleForUpdate.getModby(),
//				existingRoleForUpdate.getRoleid())).thenReturn(existingRoleForUpdate);
//		;
//
//		Role roleToBeDelete = roleService.deleteRoledetails(existingRoleForUpdate);
//
//		assertNotNull(roleToBeDelete, "Role to be deleted should not be null");
//		assertEquals(existingRoleForUpdate, roleToBeDelete, "Deleted role should be the same as the mocked role");
//		verify(roleRepository).deleteRoledetails(existingRoleForUpdate.getModdt(), existingRoleForUpdate.getModby(),
//				existingRoleForUpdate.getRoleid());
//
//	}
//
//	@Test
//	void deleteRoledetails_failure_test() throws IOException {
//		when(roleRepository.deleteRoledetails(existingRoleForUpdate.getModdt(), existingRoleForUpdate.getModby(),
//				existingRoleForUpdate.getRoleid())).thenReturn(null);
//
//		DeleteFailedException deleteFailedException = assertThrows(DeleteFailedException.class, () -> {
//			roleService.deleteRoledetails(existingRoleForUpdate);
//		});
//
//		assertEquals("Delete operation failed for role", deleteFailedException.getMessage());
//
//		verify(roleRepository, times(1)).deleteRoledetails(existingRoleForUpdate.getModdt(),
//				existingRoleForUpdate.getModby(), existingRoleForUpdate.getRoleid());
//	}

}
