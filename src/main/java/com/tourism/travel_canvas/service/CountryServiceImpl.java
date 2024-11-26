package com.tourism.travel_canvas.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	public CountryServiceImpl(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

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

	@Override
	public Country updateCountryDetails(Country country) {

		if (countryRepository.existsByCountrynameIgnoreCase(country.getCountryname())) {
			throw new IllegalArgumentException("Country name already exists. Update operation is skipped.");
		}

		Optional<Country> optionalCountry = countryRepository.findById(country.getCountryid());

		if (optionalCountry.isPresent()) {

			Country countryobj = optionalCountry.get();

			countryobj.setCountryname(country.getCountryname());
			countryobj.setActiveflag(country.getActiveflag());

			countryobj.setModby(country.getModby());
//			countryobj.setModdt(Optional.of(LocalDateTime.now()));

			countryobj.setModdt((country.getModdt()));

			return countryRepository.save(country);

		}

		else {
			throw new EntityNotFoundException("Country not found with id " + country.getCountryid());
		}
	}

}
