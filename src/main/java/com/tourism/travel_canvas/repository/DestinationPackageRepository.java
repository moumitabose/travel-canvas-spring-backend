package com.tourism.travel_canvas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.DestinationPackage;

@Repository
public interface DestinationPackageRepository extends JpaRepository<DestinationPackage, Integer> {
	
	@Query(value = "SELECT p.* FROM tourism.destination_package p WHERE p.activeflag='Y' "
			+ "AND p.destinationid=:destinationid", nativeQuery = true)
	public List<DestinationPackage> getAllPackageDetailsByDestinationId(Integer destinationid);


}
