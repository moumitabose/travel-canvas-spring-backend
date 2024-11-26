package com.tourism.travel_canvas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public List<Country> getAllCountries() {
		try {
			return List.copyOf(countryRepository.getAllCountries());
		} catch (Exception e) {
			// Log the exception and return an empty list
			System.err.println("Failed to fetch countries: " + e.getMessage());
			return List.of(); // Returns an immutable empty list
		}
	}

	@Override
	public Country saveCountryDetails(Country country) {
		try {
			return countryRepository.save(country);
		} catch (Exception e) {
			System.err.println("Failed to save country details: " + e.getMessage());
			// Optionally, you can rethrow the exception or handle it differently
			throw new RuntimeException("Save operation failed", e);
		}
	}

}
