package com.tourism.travel_canvas.repository;


import com.tourism.travel_canvas.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>  {
	
	@Query(value = "SELECT i.* FROM tourism.image i\r\n"
			+ "LEFT JOIN tourism.destination d ON i.destinationid=d.destinationid\r\n"
			+ "WHERE i.activeflag='Y' AND i.destinationid=:destinationid", nativeQuery = true)
	public Image  getImageDetailsByDestinationId(Integer destinationid );
	


}
