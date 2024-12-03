package com.tourism.travel_canvas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.exception.PackageListNotFoundException;
import com.tourism.travel_canvas.model.DestinationPackage;
import com.tourism.travel_canvas.repository.DestinationPackageRepository;

@Service
public class DestinationPackageServiceImpl implements DestinationPackageService {
	
	@Autowired
	private DestinationPackageRepository destinationPackageRepository;

	@Override
	public List<DestinationPackage> getAllPackageDetailsByDestinationId(DestinationPackage destinationPackage) {
		
		List<DestinationPackage> resultList= destinationPackageRepository
				.getAllPackageDetailsByDestinationId(destinationPackage.getDestinationid());
		
		if(resultList.size()==0)
		{
			throw new PackageListNotFoundException
			("package list not found for this destination ID:  "+destinationPackage.getDestinationid() );
		}
		
		return resultList;
	}
	
	
	
	

}
