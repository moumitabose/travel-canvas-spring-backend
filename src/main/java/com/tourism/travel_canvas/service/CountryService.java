package com.tourism.travel_canvas.service;

import java.io.IOException;
import java.util.List;

import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;

public interface CountryService {
	
	public List<Country> getAllCountries();
	
	public List<AllDetailsBean> getAllCountriesDetails();
	
	public Country saveCountryDetails(Country country) throws IOException;
	
	public void updateCountryDetails(Country country) throws IOException;

}
