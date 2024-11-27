package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//@Entity
//@Table(schema = "tourism", name = "role")
public class Role {
	
	private Integer roleid;
	private String rolename;
	private Character activeflag;
	
	
	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Integer modby;  // Changed to Integer instead of Optional<Integer>
	private LocalDateTime moddt;


	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
		return "Role{" +
				"roleid=" + roleid +
				", rolename='" + rolename + '\'' +
				", activeflag=" + activeflag +
				", createby=" + createby +
				", createdt=" + createdt +
				", modby=" + modby +
				", moddt=" + moddt +
				'}';
	}


	public Role(Integer roleid, String rolename, Character activeflag, Integer createby, LocalDateTime createdt) {
		this.roleid = roleid;
		this.rolename = rolename;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
	}



}
