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
	private Integer countryid;
	private String email;
	private String password;

	private Integer createby;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime createdt;

	private Integer modby;

	private LocalDateTime moddt;



}
