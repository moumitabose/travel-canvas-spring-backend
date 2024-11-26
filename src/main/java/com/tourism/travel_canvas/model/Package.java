package com.tourism.travel_canvas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "package")
public class Package {
	
	@Id
	private Integer packageid;
	private Integer destinationid;
	private Integer countryid;
	private Integer noofdays;
	private Integer noofnight;
	private Double priceperperson;
	private Character visarequirement;
	private Character activeflag;
	private String createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdt;

	private String modby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date moddt;

	public Integer getPackageid() {
		return packageid;
	}

	public void setPackageid(Integer packageid) {
		this.packageid = packageid;
	}

	public Integer getDestinationid() {
		return destinationid;
	}

	public void setDestinationid(Integer destinationid) {
		this.destinationid = destinationid;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public Integer getNoofdays() {
		return noofdays;
	}

	public void setNoofdays(Integer noofdays) {
		this.noofdays = noofdays;
	}

	public Integer getNoofnight() {
		return noofnight;
	}

	public void setNoofnight(Integer noofnight) {
		this.noofnight = noofnight;
	}

	public Double getPriceperperson() {
		return priceperperson;
	}

	public void setPriceperperson(Double priceperperson) {
		this.priceperperson = priceperperson;
	}

	public Character getVisarequirement() {
		return visarequirement;
	}

	public void setVisarequirement(Character visarequirement) {
		this.visarequirement = visarequirement;
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
