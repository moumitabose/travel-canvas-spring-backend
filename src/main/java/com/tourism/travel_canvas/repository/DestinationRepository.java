package com.tourism.travel_canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.Destination;
import com.tourism.travel_canvas.outputbean.AllDestinationDetails;

@Repository
public interface DestinationRepository
extends JpaRepository<Destination, Integer> {
	

	@Query(value = "SELECT d.*,co.countryname,ci.cityname FROM tourism.destination d\r\n"
			+ "LEFT JOIN tourism.country co ON co.countryid=d.countryid\r\n"
			+ "LEFT JOIN tourism.city ci ON ci.cityid=d.cityid\r\n"
			+ "WHERE d.activeflag='Y'", nativeQuery = true)
	public List<AllDestinationDetails> getAllDestinationDetails();

}
