package com.tourism.travel_canvas.outputbean;

import java.time.LocalDateTime;

public interface AllDetails {

	public Integer getUserid();

	public String getName();

	public Integer getCountryid();

	public String getEmail();

	public String getPassword();

	public Integer getCreateby();

	public LocalDateTime getCreatedt();

	public Integer getModby();

	public LocalDateTime getModdt();

	public Integer getRoleid();

	public String getRolename();

	public String getCountryname() ;
	
	public Character getActiveflag();
	

}
