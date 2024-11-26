package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "user")

public class User {

	@Id
	private Integer userid;

	private String name;
	private Integer roleid;
	private String country;

	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Optional<Integer> modby = Optional.empty();

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Optional<LocalDateTime> moddt = Optional.empty();

	public User(Integer userid, String name, Integer roleid, String country, Integer createby, LocalDateTime createdt,
			Optional<Integer> modby, Optional<LocalDateTime> moddt) {
		super();
		this.userid = userid;
		this.name = name;
		this.roleid = roleid;
		this.country = country;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby != null ? modby : Optional.empty();
		this.moddt = moddt != null ? moddt : Optional.empty();
	}

	public User(Integer userid, String name, Integer roleid, String country, Integer createby, LocalDateTime createdt) {
		super();
		this.userid = userid;
		this.name = name;
		this.roleid = roleid;
		this.country = country;
		this.createby = createby;
		this.createdt = createdt;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", roleid=" + roleid + ", country=" + country
				+ ", createby=" + createby + ", createdt=" + createdt + ", modby=" + modby + ", moddt=" + moddt + "]";
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	
	
	

}
