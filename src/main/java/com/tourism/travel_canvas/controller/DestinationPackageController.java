package com.tourism.travel_canvas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.DestinationPackage;
import com.tourism.travel_canvas.service.DestinationPackageService;

@RestController
@CrossOrigin
public class DestinationPackageController {

	@Autowired
	private DestinationPackageService destinationPackageService;
	
	
	@PostMapping("/getAllPackageDetailsByDestinationId")
	public ResponseEntity<List<DestinationPackage>> getAllPackageDetailsByDestinationId(@RequestBody
			DestinationPackage destinationPackage) {
		List<DestinationPackage> resultList = destinationPackageService
				.getAllPackageDetailsByDestinationId(destinationPackage);
		return ResponseEntity.ok(resultList);
	}

	@PostMapping("/saveDestinationPackageDetails")
	public ResponseEntity<DestinationPackage> saveDestinationPackageDetails
			(@RequestBody DestinationPackage destinationPackage)throws IOException
	{
		DestinationPackage savePackage= destinationPackageService.saveDestinationPackageDetails(destinationPackage);
		return new ResponseEntity<>(savePackage, HttpStatus.CREATED);


	}

}
