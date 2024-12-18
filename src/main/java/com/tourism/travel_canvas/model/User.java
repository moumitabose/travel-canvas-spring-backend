package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "user")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	private String username;
	private String name;

	@ManyToOne
	@JoinColumn(name = "roleid", referencedColumnName = "roleid") // foreign key
	private Role role; // Establishes the relationship with the Role table

	private Integer countryid;
	private String email;
	private String phone;
	private String password;
	private Character activeflag;

	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Integer modby;

	private LocalDateTime moddt;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getCountryid() {
		return countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Character getActiveflag() {
		return activeflag;
	}

	public void setActiveflag(Character activeflag) {
		this.activeflag = activeflag;
	}

	public User(Integer userid, String name, Role role, Integer countryid, String email, String password,
			Character activeflag, Integer createby, LocalDateTime createdt, Integer modby, LocalDateTime moddt) {
		super();
		this.userid = userid;
		this.name = name;
		this.role = role;
		this.countryid = countryid;
		this.email = email;
		this.password = password;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
		this.modby = modby;
		this.moddt = moddt;
	}

	public User(Integer userid, String name, Role role, Integer countryid, String email, String password,
			Character activeflag, Integer createby, LocalDateTime createdt) {
		super();
		this.userid = userid;
		this.name = name;
		this.role = role;
		this.countryid = countryid;
		this.email = email;
		this.password = password;
		this.activeflag = activeflag;
		this.createby = createby;
		this.createdt = createdt;
	}

	public User(Integer userid, String name) {
		super();
		this.userid = userid;
		this.name = name;
	}

	public User() {
		super();

	}

}
