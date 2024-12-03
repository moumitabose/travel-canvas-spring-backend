package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "destination_package")
public class DestinationPackage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer packageid;
	private Integer destinationid;
	private Integer noofdays;
	private Integer noofnight;
	private Double priceperperson;
	private Character activeflag;
	private Integer createby;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdt;

    private Integer modby;  
    private LocalDateTime moddt;
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
	public DestinationPackage(Integer packageid, Integer destinationid, Integer noofdays, Integer noofnight, Double priceperperson,
			 Character activeflag, Integer createby, LocalDateTime createdt, Integer modby,
			LocalDateTime moddt) {
		super();
		this.packageid = packageid;
		this.destinationid = destinationid;
		this.noofdays = noofdays;
		this.noofnight = noofnight;
		this.priceperperson = priceperperson;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby;
		this.moddt = moddt;
	}
	public DestinationPackage(Integer packageid, Integer destinationid, Integer noofdays, Integer noofnight, Double priceperperson,
			 Character activeflag, Integer createby, LocalDateTime createdt) {
		super();
		this.packageid = packageid;
		this.destinationid = destinationid;
		this.noofdays = noofdays;
		this.noofnight = noofnight;
		this.priceperperson = priceperperson;
		
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
	}
	@Override
	public String toString() {
		return "Package [packageid=" + packageid + ", destinationid=" + destinationid + ", noofdays=" + noofdays
				+ ", noofnight=" + noofnight + ", priceperperson=" + priceperperson + ",  activeflag=" + activeflag + ", createby=" + createby + ", createdt=" + createdt
				+ ", modby=" + modby + ", moddt=" + moddt + "]";
	}
	public DestinationPackage() {
		super();
	}

   
	
	
	

	

}
