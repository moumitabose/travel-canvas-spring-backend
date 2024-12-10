package com.tourism.travel_canvas.model;

import javax.persistence.*;

@Entity
@Table(schema = "tourism", name = "test")
public class Test {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer testid;
	private String testname;

	public String getTestname() {
		return testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public Integer getTestid() {
		return testid;
	}

	public void setTestid(Integer testid) {
		this.testid = testid;
	}
}
