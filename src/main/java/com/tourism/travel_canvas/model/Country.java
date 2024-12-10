package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countryid;
	private String countryname;
	private Character activeflag;
	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Integer modby; // Changed to Integer instead of Optional<Integer>
	private LocalDateTime moddt;

	public Country(Integer countryid, String countryname, Character activeflag, Integer createby,
			LocalDateTime createdt) {
		super();
		this.countryid = countryid;
		this.countryname = countryname;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
	}

	public Country() {
		super();
	}

	public Country(Integer countryid, String countryname, Character activeflag, Integer createby,
			LocalDateTime createdt, Integer modby, LocalDateTime moddt) {
		super();
		this.countryid = countryid;
		this.countryname = countryname;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby;
		this.moddt = moddt;
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

	public Integer getModby() {
		return modby;
	}

	public void setModby(Integer modby) {
		this.modby = modby;
	}

	public LocalDateTime getModdt() {
		return moddt;
	}

	public void setModdt(LocalDateTime moddt) {
		this.moddt = moddt;
	}

	@Override
	public String toString() {
		return "Country [countryid=" + countryid + ", countryname=" + countryname + ", activeflag=" + activeflag
				+ ", createby=" + createby + ", createdt=" + createdt + ", modby=" + modby + ", moddt=" + moddt + "]";
	}

}
