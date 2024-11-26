package com.tourism.travel_canvas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "visarequirement")
public class VisaRequirement {
	
	
	@Id
	private Integer visarequirementid;
	private Integer from_country;
	private Integer to_country;
	private Character activeflag;
	private Integer  processing_time;
	private Double visafee;
	private String createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date createdt;

	private String modby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date moddt;

	public Integer getVisarequirementid() {
		return visarequirementid;
	}

	public void setVisarequirementid(Integer visarequirementid) {
		this.visarequirementid = visarequirementid;
	}

	public Integer getFrom_country() {
		return from_country;
	}

	public void setFrom_country(Integer from_country) {
		this.from_country = from_country;
	}

	public Integer getTo_country() {
		return to_country;
	}

	public void setTo_country(Integer to_country) {
		this.to_country = to_country;
	}

	public Character getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(Character activeflag) {
		this.activeflag = activeflag;
	}

	public Integer getProcessing_time() {
		return processing_time;
	}

	public void setProcessing_time(Integer processing_time) {
		this.processing_time = processing_time;
	}

	public Double getVisafee() {
		return visafee;
	}

	public void setVisafee(Double visafee) {
		this.visafee = visafee;
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
