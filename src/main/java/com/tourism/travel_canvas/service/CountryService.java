package com.tourism.travel_canvas.service;

import java.util.List;

import com.tourism.travel_canvas.model.Country;

public interface CountryService {
	
	public List<Country> getAllCountries();
	
	public Country saveCountryDetails(Country country);
	
	public Country updateCountryDetails(Country country);

}
