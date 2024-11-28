package com.tourism.travel_canvas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourism.travel_canvas.model.Destination;
import com.tourism.travel_canvas.outputbean.AllDestinationDetails;
import com.tourism.travel_canvas.outputbean.AllDestinationDetailsBean;
import com.tourism.travel_canvas.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationRepository destinationRepository;

	@Override
	public List<AllDestinationDetailsBean> getAllDestinationDetails() {

		List<AllDestinationDetailsBean> resultDestinationList = new ArrayList<AllDestinationDetailsBean>();

		List<AllDestinationDetails> destinationListBean = destinationRepository.getAllDestinationDetails();

		destinationListBean.forEach(des -> {
			AllDestinationDetailsBean allDestinationDetailsBean = new AllDestinationDetailsBean();

			allDestinationDetailsBean.setDestinationid(des.getDestinationid());
			allDestinationDetailsBean.setCountryid(des.getCountryid());
			allDestinationDetailsBean.setCountryname(des.getCountryname());
			allDestinationDetailsBean.setCityid(des.getCityid());
			allDestinationDetailsBean.setCityname(des.getCityname());

			resultDestinationList.add(allDestinationDetailsBean);
		});

		return resultDestinationList;
	}

}
