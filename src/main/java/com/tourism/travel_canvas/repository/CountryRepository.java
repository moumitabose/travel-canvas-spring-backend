package com.tourism.travel_canvas.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tourism.travel_canvas.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

	@Query(value = "SELECT * FROM  tourism.country WHERE activeflag='Y' ORDER BY countryid ASC", nativeQuery = true)
	public List<Country> getAllCountries();

	@Query(value = "SELECT * FROM  tourism.country WHERE activeflag='Y' ORDER BY countryid ASC", nativeQuery = true)
	public List<Country> getAllCountriesDetails();

	@Query(value = "SELECT * FROM  tourism.country WHERE activeflag='Y' AND countryid=:countryid"
			+ "  ORDER BY countryid ASC", nativeQuery = true)
	public Country getAllCountryByCountryId(Integer countryid);

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "UPDATE tourism.country c SET c.countryname=:countryname, c.activeflag='N',"
			+ "c.moddt=:moddt,c.modby=:modby  WHERE c.countryid=:countryid", nativeQuery = true)
	@Transactional
	public void updateCountryDetails(String countryname, LocalDateTime moddt, Integer modby, Integer countryid);

}
