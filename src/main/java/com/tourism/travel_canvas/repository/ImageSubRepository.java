package com.tourism.travel_canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.ImageSub;

@Repository
public interface ImageSubRepository extends JpaRepository<ImageSub, Integer> {


	@Query(value = "SELECT img.* FROM tourism.image_sub img\r\n"
			+ "LEFT JOIN tourism.destination d ON img.destinationid = d.destinationid\r\n"
			+ "WHERE img.activeflag = 'Y' AND img.destinationid = :destinationid",
			nativeQuery = true)
	public List<ImageSub> getAllSubImageDetailsByDestinationId(Integer destinationid);

}
