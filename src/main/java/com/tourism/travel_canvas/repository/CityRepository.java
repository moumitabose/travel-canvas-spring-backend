package com.tourism.travel_canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.City;
import com.tourism.travel_canvas.outputbean.AllCityDetails;


@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
	
	@Query(value = "SELECT ci.*,co.countryname FROM tourism.city ci\r\n"
			+ "LEFT JOIN tourism.country co ON ci.countryid=co.countryid\r\n"
			+ "WHERE d.activeflag='Y'", nativeQuery = true)
	public List<AllCityDetails> getAllCityDetails();
	
	

}
