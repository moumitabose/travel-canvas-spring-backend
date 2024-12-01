package com.tourism.travel_canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tourism.travel_canvas.outputbean.AllDestinationDetailsBean;
import com.tourism.travel_canvas.service.DestinationService;

@RestController
@CrossOrigin
public class DestinationController {
	
	@Autowired
	private DestinationService destinationService;
	
	
	@GetMapping("/getAllDestinationDetails")
	public List<AllDestinationDetailsBean> getAllDestinationDetails()
	{
		return destinationService.getAllDestinationDetails();
	}

}
