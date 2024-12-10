package com.tourism.travel_canvas.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.service.CountryService;

@RestController
@CrossOrigin
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/getAllCountries")
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> countryList = countryService.getAllCountries();
		return ResponseEntity.ok(countryList);
	}

	@GetMapping("/getAllCountriesDetails")
	public ResponseEntity<List<AllDetailsBean>> getAllCountriesDetails() {
		List<AllDetailsBean> countryFinalList = countryService.getAllCountriesDetails();
		return ResponseEntity.ok(countryFinalList);
	}

	@PostMapping("/saveCountryDetails")
	public ResponseEntity<Country> saveCountryDetails(@RequestBody Country country) throws IOException {
		Country savedCountry = countryService.saveCountryDetails(country);
		return new ResponseEntity<>(savedCountry, HttpStatus.CREATED);
	}
	
	@PostMapping("/updateCountryDetails")
	public ResponseEntity<String> updateCountryDetails(@RequestBody Country country) throws IOException {
		
		countryService.updateCountryDetails(country);
		return new ResponseEntity<>("Country details updated successfully", HttpStatus.CREATED);
		
	}
	
}
