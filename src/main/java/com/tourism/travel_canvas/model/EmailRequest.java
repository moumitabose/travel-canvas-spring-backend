package com.tourism.travel_canvas.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(schema = "tourism", name = "email_request")
public class EmailRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emailrequestid;
	@OneToOne
	@JoinColumn(name = "userid", referencedColumnName = "userid") // foreign key
	private User user;
	private String recipient;
	private String subject;
	private String body;
	private Character activeflag;
	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Integer modby;

	private LocalDateTime moddt;

	public Integer getEmailrequestid() {
		return emailrequestid;
	}

	public void setEmailrequestid(Integer emailrequestid) {
		this.emailrequestid = emailrequestid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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
