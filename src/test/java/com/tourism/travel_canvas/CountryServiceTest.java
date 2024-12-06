package com.tourism.travel_canvas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

import com.tourism.travel_canvas.exception.CountryNotFoundException;
import com.tourism.travel_canvas.exception.SaveFailedException;
import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.repository.CountryRepository;
import com.tourism.travel_canvas.repository.UserRepository;
import com.tourism.travel_canvas.service.CountryService;
import com.tourism.travel_canvas.service.CountryServiceImpl;

public class CountryServiceTest {

	private CountryRepository countryRepository;

	private CountryService countryService;

	private UserRepository userRepository;
	
	private Country toSaveCountry;

	@BeforeEach
	void setup() {
		countryRepository = Mockito.mock(CountryRepository.class);

		countryService = new CountryServiceImpl(countryRepository);

		userRepository = Mockito.mock(UserRepository.class);
		
		toSaveCountry = new Country(1, "India", 'Y', 1, LocalDateTime.now());
	}

	@Test
	void getAllCountries_test() {
		List<Country> countryList = List.of(new Country(1, "India", 'Y', 1, LocalDateTime.now()),
				new Country(2, "USA", 'Y', 2, LocalDateTime.now()));

		when(countryRepository.getAllCountries()).thenReturn(countryList);

		List<Country> result = countryService.getAllCountries();

		assertNotNull(result);

		assertEquals(countryList.size(), result.size(), "Both List will get the same length");

		verify(countryRepository, times(1)).getAllCountries();
	}

	@Test
	void getAllCountries_empty_list_test() {
		when(countryRepository.getAllCountries()).thenReturn(null);

		CountryNotFoundException countryNotFoundException = assertThrows(CountryNotFoundException.class, () -> {
			countryService.getAllCountries();
		});
		assertEquals("Empty List of Country", countryNotFoundException.getMessage());

		verify(countryRepository, times(1)).getAllCountries();
	}

	@Test
	void getAllCountriesDetails_test() {
		List<Country> countryList = List
				.of(new Country(1, "India", 'Y', 101, LocalDateTime.now(), 102, LocalDateTime.now()));

		when(countryRepository.getAllCountriesDetails()).thenReturn(countryList);

		User userone = new User(101, "Moumita");
		User usertwo = new User(102, "Sumit");

		when(userRepository.geUserDetailsByuserid(101)).thenReturn(userone);
		when(userRepository.geUserDetailsByuserid(102)).thenReturn(usertwo);

		List<AllDetailsBean> countryFinalList = countryService.getAllCountriesDetails();

		assertNotNull(countryFinalList);
		assertEquals(countryList.size(), countryFinalList.size(), "same size will return");

		AllDetailsBean countryDetails = countryFinalList.get(0);

		assertEquals("India", countryDetails.getCountryname());
		assertEquals("Moumita", countryDetails.getCreatename());
		assertEquals("Sumit", countryDetails.getModname());

		verify(countryRepository, times(1)).getAllCountriesDetails();

	}

	@Test
	void getAllCountriesDetails_empty_list_test() {
		when(countryRepository.getAllCountriesDetails()).thenReturn(null);

		CountryNotFoundException countryNotFoundException = assertThrows(CountryNotFoundException.class, () -> {
			countryService.getAllCountriesDetails();
		});
		assertEquals("Empty List of Country", countryNotFoundException.getMessage());

		verify(countryRepository, times(1)).getAllCountriesDetails();
	}

	@Test
	void getAllCountriesDetails_user_is_null_test() {
		List<Country> countryList = List
				.of(new Country(1, "India", 'Y', 101, LocalDateTime.now(), 102, LocalDateTime.now()));

		when(countryRepository.getAllCountriesDetails()).thenReturn(countryList);

		when(userRepository.geUserDetailsByuserid(101)).thenReturn(null);
		when(userRepository.geUserDetailsByuserid(102)).thenReturn(null);

		List<AllDetailsBean> countryFinalList = countryService.getAllCountriesDetails();

		assertNotNull(countryFinalList);
		assertEquals(countryList.size(), countryFinalList.size(), "same size will return");

		AllDetailsBean countryDetails = countryFinalList.get(0);

		assertEquals("India", countryDetails.getCountryname());
		assertNull(countryDetails.getCreatename());
		assertNull(countryDetails.getModname());

		verify(countryRepository, times(1)).getAllCountriesDetails();
	}

	@Test
	void saveCountryDetails_test() {

		Country savedCountry = new Country(1, "India", 'Y', 1, LocalDateTime.now());

		when(countryRepository.save(toSaveCountry)).thenReturn(savedCountry);

		Country resultCountry = countryService.saveCountryDetails(toSaveCountry);

		assertEquals(savedCountry.getCountryname(), resultCountry.getCountryname(), "should return same country name");

		verify(countryRepository, times(1)).save(toSaveCountry);

	}

	@Test
	void saveCountryDetails_empty_test() {

		
		when(countryRepository.save(toSaveCountry)).thenReturn(null);

		SaveFailedException saveFailedException = assertThrows(SaveFailedException.class, () -> {
			countryService.saveCountryDetails(toSaveCountry);
		});

		assertEquals("Failed to save country", saveFailedException.getMessage());

		verify(countryRepository, times(1)).save(toSaveCountry);

	}
	
	void updateCountryDetails_test()
	{
		
		Country updatedCountry = new Country(1, "UK", 'Y', 1, LocalDateTime.now(),2,LocalDateTime.now());
		when(countryRepository.getAllCountries().stream()
				.anyMatch(r -> r.getCountryname().equalsIgnoreCase(toSaveCountry.getCountryname()))).thenReturn(false);
		
		when(countryRepository.getAllCountryByCountryId(1)).thenReturn(toSaveCountry);
		
//		when(countryRepository.updateCountryDetails(updatedCountry.getCountryname(), updatedCountry.getModdt(), 
//				updatedCountry.getModby(), updatedCountry.getCountryid())).thenReturn(updatedCountry);
		
		
	}

}
