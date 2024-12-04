package com.tourism.travel_canvas.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.tourism.travel_canvas.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	@Query(value = "SELECT * FROM  tourism.login WHERE username=:username and password=:password", nativeQuery = true)
	public Login findLoginByUserId(String username,String password);
	
	

	

}
