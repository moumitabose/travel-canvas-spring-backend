package com.tourism.travel_canvas.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(schema = "tourism", name = "login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loginid;
	
	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid") // foreign key
	private User user;
	private String username;
	private String password;
	private Date todt;
	private Date fromdt;

	private Character activeflag;

	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Integer modby;
	private LocalDateTime moddt;
	public Integer getLoginid() {
		return loginid;
	}
	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getTodt() {
		return todt;
	}
	public void setTodt(Date todt) {
		this.todt = todt;
	}
	public Date getFromdt() {
		return fromdt;
	}
	public void setFromdt(Date fromdt) {
		this.fromdt = fromdt;
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
	
	
	
	
	
	

	
}
