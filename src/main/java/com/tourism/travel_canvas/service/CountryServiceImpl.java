package com.tourism.travel_canvas.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.exception.CountryNotFoundException;
import com.tourism.travel_canvas.exception.SaveFailedException;
import com.tourism.travel_canvas.exception.UpdateFailedException;
import com.tourism.travel_canvas.model.Country;
import com.tourism.travel_canvas.model.User;
import com.tourism.travel_canvas.outputbean.AllDetailsBean;
import com.tourism.travel_canvas.repository.CountryRepository;
import com.tourism.travel_canvas.repository.RoleRepository;
import com.tourism.travel_canvas.repository.UserRepository;

@Service
public class CountryServiceImpl implements CountryService {

	private CountryRepository countryRepository;
	private UserRepository userRepository;

	public CountryServiceImpl() {

	}

	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository, UserRepository userRepository) {
		this.countryRepository = countryRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Country> getAllCountries() {

		List<Country> countryList = countryRepository.getAllCountries();
		if (countryList == null || countryList.isEmpty()) {
			throw new CountryNotFoundException("Empty List of Country");
		}
		return countryList;

	}

	@Override
	public List<AllDetailsBean> getAllCountriesDetails() {
	    List<Country> countryList = countryRepository.getAllCountriesDetails();

	    if (countryList == null || countryList.isEmpty()) {
	        throw new CountryNotFoundException("Empty List of Country");
	    } else {
	        List<AllDetailsBean> countryFinalList = new ArrayList<>();

	        countryList.forEach(country -> {
	            AllDetailsBean countryDetails = new AllDetailsBean();

	            countryDetails.setCountryid(country.getCountryid());
	            countryDetails.setCountryname(country.getCountryname());
	            countryDetails.setActiveflag(country.getActiveflag());
	            countryDetails.setCreateby(country.getCreateby());

	            User user = userRepository.geUserDetailsByuserid(country.getCreateby());
	            if (user != null) {
	                countryDetails.setCreatename(user.getName());
	            }

	            countryDetails.setCreatedt(country.getCreatedt());
	            countryDetails.setModby(country.getModby());

	            if (country.getModby() != null) {
	                User usermodby = userRepository.geUserDetailsByuserid(country.getModby());
	                if (usermodby != null) {
	                    countryDetails.setModname(usermodby.getName());
	                }
	            }

	            countryDetails.setModdt(country.getModdt());
	            countryFinalList.add(countryDetails);
	        });

	        return countryFinalList;
	    }
	}

	@Override
	public Country saveCountryDetails(Country country) {

		Country savedCountry = countryRepository.save(country);

		if (savedCountry == null) {
			throw new SaveFailedException("Failed to save country");
		}
		return savedCountry;

	}

	@Override
	public void updateCountryDetails(Country country) {

		boolean duplicateCountryNameFlag = countryRepository.getAllCountries().stream()
				.anyMatch(r -> r.getCountryname().equalsIgnoreCase(country.getCountryname()));

		if (!duplicateCountryNameFlag) {
			Country countryId = countryRepository.getAllCountryByCountryId(country.getCountryid());
			if (countryId.getCountryid() != 0) {
				countryRepository.updateCountryDetails(country.getCountryname(), country.getModdt(), country.getModby(),
						country.getCountryid());
			} else {
				throw new CountryNotFoundException("Country Not found with this country id");
			}

		}

		else {
			throw new UpdateFailedException("Failed to update country");
		}

	}

}
