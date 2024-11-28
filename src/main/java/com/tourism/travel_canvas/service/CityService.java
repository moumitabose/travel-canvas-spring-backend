package com.tourism.travel_canvas.service;

import java.util.List;

import com.tourism.travel_canvas.model.City;
import com.tourism.travel_canvas.outputbean.AllCityDetailsBean;

public interface CityService {
	
	public List<AllCityDetailsBean> getAllCityDetails();
	
	public List<City> test();
	

}
