package com.tourism.travel_canvas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.Destination;
import com.tourism.travel_canvas.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {
	
	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public List<Destination> getAllDestinantion() {
		
		return destinationRepository.findAll();
	}

}
