package com.tourism.travel_canvas.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class City {

    private Integer cityid;
    private Integer countryid;
    private String cityname;
    private Character activeflag;
    private Integer createby;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdt;

    private Integer modby;  // Changed to Integer instead of Optional<Integer>
    private LocalDateTime moddt;


    public City(Integer cityid, Integer countryid, String cityname, Character activeflag, Integer createby, LocalDateTime createdt, Integer modby, LocalDateTime moddt) {
        this.cityid = cityid;
        this.countryid = countryid;
        this.cityname = cityname;
        this.activeflag = activeflag;
        this.createby = createby;
        this.createdt = createdt;
        this.modby = modby;
        this.moddt = moddt;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getCountryid() {
        return countryid;
    }

    public void setCountryid(Integer countryid) {
        this.countryid = countryid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
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
        return "City{" +
                "cityid=" + cityid +
                ", countryid=" + countryid +
                ", cityname='" + cityname + '\'' +
                ", activeflag=" + activeflag +
                ", createby=" + createby +
                ", createdt=" + createdt +
                ", modby=" + modby +
                ", moddt=" + moddt +
                '}';
    }
}
