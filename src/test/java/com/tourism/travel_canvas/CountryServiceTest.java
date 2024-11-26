package com.tourism.travel_canvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.repository.CountryRepository;
import com.tourism.travel_canvas.service.CountryService;
import com.tourism.travel_canvas.service.CountryServiceImpl;

public class CountryServiceTest {

	private CountryRepository countryRepository;

	private CountryService countryService;

	@BeforeEach
	void setup() {
		countryRepository = Mockito.mock(CountryRepository.class);

		countryService = new CountryServiceImpl(countryRepository);
	}

//	private final CountryRepository countryRepository = Mockito.mock(CountryRepository.class);
//
//	private final CountryService countryService = new CountryServiceImpl(countryRepository);

	@Test
	void getAllCountries_test_success() {

		List<Country> mockCountries = List.of(new Country(1, "USA", 'Y', 1, LocalDateTime.now()),
				new Country(2, "INDIA", 'Y', 1, LocalDateTime.now()));

		when(countryRepository.getAllCountries()).thenReturn(mockCountries);

		List<Country> result = countryService.getAllCountries();

		assertEquals(result, mockCountries, "Should return the list of countries");

		verify(countryRepository, times(1)).getAllCountries();

	}

	@Test
	void getAllCountries_test_exception() {

		when(countryRepository.getAllCountries()).thenThrow(new RuntimeException("Database Error"));

		List<Country> result = countryService.getAllCountries();

		assertEquals(List.of(), result, "Should return an empty list when exception occurs");

		verify(countryRepository, times(1)).getAllCountries();

	}

	@Test
	void saveCountryDetails_test_success() {

		Country savedCountry = new Country(1, "USA", 'Y', 1, LocalDateTime.now());

		Country countryToSave = new Country(1, "USA", 'Y', 1, LocalDateTime.now());// same data

		when(countryRepository.save(countryToSave)).thenReturn(savedCountry);

		Country result = countryService.saveCountryDetails(countryToSave);

		assertEquals(savedCountry, result, "The saved country should be returned from the service");

		// Optionally: Verify that the repository's save method was called once with the
		// correct country
		verify(countryRepository, times(1)).save(countryToSave);

	}

	@Test
	public void testSaveCountryDetails_ExceptionThrown() {
		Country country = new Country(1, "USA", 'Y', 1, LocalDateTime.now());

		when(countryRepository.save(country)).thenThrow(new RuntimeException("Database Error"));

		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			countryService.saveCountryDetails(country);
		});

		assertEquals("Save operation failed", exception.getMessage(), "MATCHED");

		verify(countryRepository, times(1)).save(country);
	}

	@Test
	void testUpdateCountryDetails_CountryFound() {

		Country country = new Country(1, "USA", 'Y', 1, LocalDateTime.now());

		when(countryRepository.existsByCountrynameIgnoreCase(country.getCountryname())).thenReturn(true);
		// Country name exists
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			countryService.updateCountryDetails(country);

		});

		assertEquals("Country found with same name " + country.getCountryname(), thrown.getMessage());
	}

	@Test
	void testUpdateCountryDetails_CountryNotFound() {

		Country country = new Country(1, "USA", 'Y', 1, LocalDateTime.now());

		when(countryRepository.existsByCountrynameIgnoreCase(country.getCountryname())).thenReturn(false);
		// Country name doesn't exist
		when(countryRepository.findById(country.getCountryid())).thenReturn(Optional.empty());// NO ID IN DB

		// Act & Assert
		EntityNotFoundException thrown = assertThrows(EntityNotFoundException.class, () -> {
			countryService.updateCountryDetails(country);
		});
		assertEquals("Country not found with id " + country.getCountryid(), thrown.getMessage());
	}

	@Test
	void testUpdateCountryDetails_SuccessfulUpdate() {

		Country country = new Country(1, "USA", 'Y', 1, LocalDateTime.now());

		// Mock repository behavior
		when(countryRepository.existsByCountrynameIgnoreCase(country.getCountryname())).thenReturn(false);
		// Country name doesn't exist
		when(countryRepository.findById(country.getCountryid())).thenReturn(Optional.of(country));
		// Country exists in the repository
		when(countryRepository.save(country)).thenReturn(country); // Save method returns the updated country

		// Act
		Country updatedCountry = countryService.updateCountryDetails(country);

		// Assert
		assertNotNull(updatedCountry);
		assertEquals("USA", updatedCountry.getCountryname()); // Assert country name
		assertEquals('Y', updatedCountry.getActiveflag()); // Assert active flag
		assertEquals(1, updatedCountry.getModby()); // Assert modified by user
		verify(countryRepository, times(1)).save(country); // Verify that save method is called once
	}

}
