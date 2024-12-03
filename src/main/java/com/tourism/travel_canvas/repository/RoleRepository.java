package com.tourism.travel_canvas.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "SELECT r.* FROM tourism.role r WHERE r.activeflag='Y'", nativeQuery = true)
	public List<Role> getAllRoles();

	@Query(value = "SELECT r.* FROM tourism.role r WHERE r.activeflag='Y' AND r.roleid=:roleid", nativeQuery = true)
	public Role getRoleDetailsByRoleId(Integer roleid);

	@Query(value = "SELECT r.* FROM tourism.role r WHERE r.activeflag='Y' AND LOWER(r.rolename) = LOWER(:rolename)",
			nativeQuery = true)
	public List<Role> getAllRolesByRoleName(String rolename);

	@Modifying
	@Query(value = "UPDATE tourism.role SET rolename=:rolename,moddt=:moddt,modby=:modby "
			+ " WHERE roleid=:roleid", nativeQuery = true)
	@Transactional
	public Role updateRoledetails(String rolename, LocalDateTime moddt, Integer modby, Integer roleid);

	@Modifying
	@Query(value = "UPDATE tourism.role SET activeflag='N',moddt=:moddt,modby=:modby "
			+ " WHERE roleid=:roleid", nativeQuery = true)
	@Transactional
	public Role deleteRoledetails(LocalDateTime moddt, Integer modby, Integer roleid);

}