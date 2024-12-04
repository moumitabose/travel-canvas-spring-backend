package com.tourism.travel_canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.AllDetails;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT u.*,co.countryname,r.rolename FROM tourism.user u"
			+ "LEFT JOIN tourism.role r ON u.roleid=r.roleid "
			+ "LEFT JOIN tourism.country co ON u.countryid=co.countryid WHERE u.activeflag='Y'"
			+ "ORDER BY userid ASC  ", nativeQuery = true)
	public List<AllDetails> getAllUserDetails();

	@Query(value = "SELECT u.* FROM tourism.user u WHERE u.userid=:userid", nativeQuery = true)
	public User geUserDetailsByuserid(Integer userid);



}
