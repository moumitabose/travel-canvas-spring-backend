package com.tourism.travel_canvas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.City;
import com.tourism.travel_canvas.outputbean.AllCityDetailsBean;
import com.tourism.travel_canvas.service.CityService;

@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/getAllCityDetails")
	public List<AllCityDetailsBean> getAllCityDetails() 
	{
		return cityService.getAllCityDetails();
	}
	
	@GetMapping("/citytest")
	public List<City> test()
	{
		return cityService.test();
	}

}
