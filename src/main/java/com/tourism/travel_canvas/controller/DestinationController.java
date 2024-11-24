package com.tourism.travel_canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.Destination;
import com.tourism.travel_canvas.service.DestinationService;

@RestController
public class DestinationController {
	
	@Autowired
	private DestinationService destinationService;
	
	@GetMapping("/getAllDestinantion")
	public List<Destination> getAllDestinantion()
	{
		return destinationService.getAllDestinantion();
	}

}
