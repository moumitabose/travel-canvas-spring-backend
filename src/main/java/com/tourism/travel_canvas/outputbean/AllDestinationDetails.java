package com.tourism.travel_canvas.outputbean;

import java.time.LocalDateTime;

public interface AllDestinationDetails {

	public Integer getDestinationid();

	public Integer getCityid();

	public Integer getCountryid();

	public Character getActiveflag();

	public Integer getCreateby();

	public LocalDateTime getCreatedt();

	public Integer getModby();

	public LocalDateTime getModdt();
	
	public String getCountryname();
	
	public String getCityname();

}
