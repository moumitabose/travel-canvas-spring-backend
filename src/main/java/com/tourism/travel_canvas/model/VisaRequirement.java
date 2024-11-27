package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
//@Table(schema = "tourism", name = "visa_requirement")
public class VisaRequirement {
	
	
//	@Id
	private Integer visarequirementid;
	private Integer from_country;
	private Integer to_country;
	private Character activeflag;
	private Integer  processing_time;
	private Double visafee;
	private String createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Optional<String> modby = Optional.empty();

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Optional<LocalDateTime> moddt = Optional.empty();

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

	



	
	
	

}
