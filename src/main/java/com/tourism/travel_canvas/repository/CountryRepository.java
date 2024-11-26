package com.tourism.travel_canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.tourism.travel_canvas.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	
	@Query(value = "SELECT * FROM  tourism.country WHERE activeflag='Y' ORDER BY countryid ASC", nativeQuery = true)
	public List<Country> getAllCountries();
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Country c "
			+ "WHERE LOWER(c.countryname) = LOWER(:countryname)", nativeQuery = true)
    boolean existsByCountrynameIgnoreCase(String countryname); 

	
	

}
