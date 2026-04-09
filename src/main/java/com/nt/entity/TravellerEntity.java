package com.nt.entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="REST_TRAVELLER")
public class TravellerEntity {
    //Data properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer tid;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String country;

    private Long mobileno;
    private LocalDate dob;

    @Column(length = 30)
    private String currentLocation;

    @Column(length = 30)
    private String headingTo;

   

    //metadata properties
   //@CreationTimestamp is a Hibernate annotation used to automatically set the 
    //current date and time when a record is created (inserted into the database).
    @CreationTimestamp
    private LocalDateTime registeredOn;

    //@UpdateTimestamp is a Hibernate annotation used to automatically 
    //update the date and time whenever a record is modified (UPDATE operation).
    @UpdateTimestamp
    private LocalDateTime lastUpdatedOn;

    @Column(length = 30)
    private String createdBy;

  
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

	

	public LocalDateTime getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(LocalDateTime registeredOn) {
		this.registeredOn = registeredOn;
	}

	public LocalDateTime getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
}