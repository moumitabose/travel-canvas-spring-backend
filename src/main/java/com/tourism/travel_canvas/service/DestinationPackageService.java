package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;

import com.tourism.travel_canvas.model.DestinationPackage;

public interface DestinationPackageService {
	
	public List<DestinationPackage> getAllPackageDetailsByDestinationId(DestinationPackage destinationPackage);

	public DestinationPackage saveDestinationPackageDetails
			(DestinationPackage destinationPackage) throws IOException;

}