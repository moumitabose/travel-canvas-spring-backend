package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "destination")
public class Destination {
	

	@Id
//	@SequenceGenerator(initialValue = 1, name = "company_master_seq", allocationSize = 0)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_master_seq")
	private Integer destinationid;
	private Integer cityid;
	private Integer countryid;
	private Character activeflag;
	private String createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Optional<String> modby = Optional.empty();

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Optional<LocalDateTime> moddt = Optional.empty();

	public Integer getDestinationid() {
		return destinationid;
	}

	public void setDestinationid(Integer destinationid) {
		this.destinationid = destinationid;
	}

	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
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

	public LocalDateTime getCreatedt() {
		return createdt;
	}

	public void setCreatedt(LocalDateTime createdt) {
		this.createdt = createdt;
	}

	public Optional<String> getModby() {
		return modby;
	}

	public void setModby(Optional<String> modby) {
		this.modby = modby;
	}

	public Optional<LocalDateTime> getModdt() {
		return moddt;
	}

	public void setModdt(Optional<LocalDateTime> moddt) {
		this.moddt = moddt;
	}

	
	
	
	@Override
	public String toString() {
		return "Destination [destinationid=" + destinationid + ", cityid=" + cityid + ", countryid=" + countryid
				+ ", activeflag=" + activeflag + ", createby=" + createby + ", createdt=" + createdt + ", modby="
				+ modby + ", moddt=" + moddt + "]";
	}

	
	
	


}
