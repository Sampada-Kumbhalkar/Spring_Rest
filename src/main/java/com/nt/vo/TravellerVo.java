package com.nt.vo;

import java.time.LocalDate;

public class TravellerVo {

	  
	    private Integer tid;

	  
	    private String name;

	    private String country;

	    private Long mobileno;
	    private LocalDate dob;

	  
	    private String currentLocation;

	  
	    private String headingTo;


		public Integer getTid() {
			return tid;
		}


		public void setTid(Integer tid) {
			this.tid = tid;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getCountry() {
			return country;
		}


		public void setCountry(String country) {
			this.country = country;
		}


		public Long getMobileno() {
			return mobileno;
		}


		public void setMobileno(Long mobileno) {
			this.mobileno = mobileno;
		}


		public LocalDate getDob() {
			return dob;
		}


		public void setDob(LocalDate dob) {
			this.dob = dob;
		}


		public String getCurrentLocation() {
			return currentLocation;
		}


		public void setCurrentLocation(String currentLocation) {
			this.currentLocation = currentLocation;
		}


		public String getHeadingTo() {
			return headingTo;
		}


		public void setHeadingTo(String headingTo) {
			this.headingTo = headingTo;
		}
}
