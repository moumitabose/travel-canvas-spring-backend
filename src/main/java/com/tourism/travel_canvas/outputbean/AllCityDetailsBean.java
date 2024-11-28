package com.tourism.travel_canvas.outputbean;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AllCityDetailsBean {
	
	   private Integer cityid;
	    private Integer countryid;
	    private String cityname;
	    private Character activeflag;
	    private Integer createby;

	    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	    private LocalDateTime createdt;

	    private Integer modby;  // Changed to Integer instead of Optional<Integer>
	    private LocalDateTime moddt;
	    
		private String countryname;

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

		public String getCountryname() {
			return countryname;
		}

		public void setCountryname(String countryname) {
			this.countryname = countryname;
		}
		
		
		

}
