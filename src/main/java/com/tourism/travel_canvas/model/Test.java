package com.tourism.travel_canvas.model;

import javax.persistence.*;

@Entity
@Table(schema = "tourism", name = "test")
public class Test {

    @Id
//    @SequenceGenerator(initialValue = 1, name = "test_seq", allocationSize = 0)
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_seq")

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
