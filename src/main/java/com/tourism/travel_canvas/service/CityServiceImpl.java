package com.tourism.travel_canvas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourism.travel_canvas.outputbean.AllCityDetails;
import com.tourism.travel_canvas.outputbean.AllCityDetailsBean;
import com.tourism.travel_canvas.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public List<AllCityDetailsBean> getAllCityDetails() {

		List<AllCityDetailsBean> resultCityList = new ArrayList<AllCityDetailsBean>();

		List<AllCityDetails> cityListBean = cityRepository.getAllCityDetails();

		cityListBean.forEach(city -> {
			AllCityDetailsBean allCityDetailsBean = new AllCityDetailsBean();


			allCityDetailsBean.setCountryid(city.getCountryid());
			allCityDetailsBean.setCountryname(city.getCountryname());
			allCityDetailsBean.setCityid(city.getCityid());
			allCityDetailsBean.setCityname(city.getCityname());

			resultCityList.add(allCityDetailsBean);
		});

		return resultCityList;

	}



}
