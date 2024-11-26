package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "role")
public class Role {
	
	private Integer roleid;
	private Integer rolename;
	private Character activeflag;
	
	
	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Optional<Integer> modby = Optional.empty();

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Optional<LocalDateTime> moddt = Optional.empty();

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getRolename() {
		return rolename;
	}

	public void setRolename(Integer rolename) {
		this.rolename = rolename;
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
	
	
	
	

}
