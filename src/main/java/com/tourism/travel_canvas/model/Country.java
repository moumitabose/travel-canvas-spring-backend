package com.tourism.travel_canvas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "country")
public class Country {
	
	@Id
	private Integer countryid;
	private String countryname;
	private Character activeflag;
	private String createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdt;

	private String modby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date moddt;

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public Character getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(Character activeflag) {
		this.activeflag = activeflag;
	}

	public String getCreateby() {
		return createby;
	}

	public void setCreateby(String createby) {
		this.createby = createby;
	}

	public Date getCreatedt() {
		return createdt;
	}

	public void setCreatedt(Date createdt) {
		this.createdt = createdt;
	}

	public String getModby() {
		return modby;
	}

	public void setModby(String modby) {
		this.modby = modby;
	}

	public Date getModdt() {
		return moddt;
	}

	public void setModdt(Date moddt) {
		this.moddt = moddt;
	}
	
	
	
	


	
	

}
