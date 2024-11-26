package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;

import java.util.Optional;

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
	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Optional<Integer> modby = Optional.empty();

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Optional<LocalDateTime> moddt = Optional.empty();
	
	

	public Country() {
		super();
	}

	public Country(Integer countryid, String countryname, Character activeflag, Integer createby,
			LocalDateTime createdt, Optional<Integer> modby, Optional<LocalDateTime> moddt) {
		super();
		this.countryid = countryid;
		this.countryname = countryname;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby != null ? modby : Optional.empty();
        this.moddt = moddt != null ? moddt : Optional.empty();
	}
	
	 // Constructor without modby and moddt
    public Country(Integer countryid, String countryname, Character activeflag, Integer createby, LocalDateTime createdt) {
        this(countryid, countryname, activeflag, createby, createdt, Optional.empty(), Optional.empty());
    }

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

	public Integer getCreateby() {
		return createby;
	}

	public void setCreateby(Integer createby) {
		this.createby = createby;
	}

	public LocalDateTime getCreatedt() {
		return createdt;
	}

	public void setCreatedt(LocalDateTime createdt) {
		this.createdt = createdt;
	}

	public Optional<Integer> getModby() {
		return modby;
	}

	public void setModby(Optional<Integer> modby) {
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
		return String.format("Country[id=%d, name='%s', activeflag='%s']", countryid, countryname, activeflag);
	}

}
