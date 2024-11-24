package com.tourism.travel_canvas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "tourism", name = "destination")
public class Destination {
	
	@Id
	private Integer destinationid;
	private String country;
	public Integer getDestinationid() {
		return destinationid;
	}
	public void setDestinationid(Integer destinationid) {
		this.destinationid = destinationid;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	
	
	
	

}
