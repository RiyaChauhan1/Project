package com.project.dto;

import java.sql.Timestamp;
import java.util.Date;

public class SerchFlightDto 
{
	private int SheduleId;
	private String source;
	private String destination;
	private String takeoffDate;
	private String landingDate;
	private String CompanyName;
	private String landingTime;
	private String takeoffTime;
	private double price;
	private int avalable_Seat;
//	private int avalable_Business_seat;
//	private int avalable_first_seat;
	
	public SerchFlightDto() {
		
	}
	
	
	

	public SerchFlightDto(int sheduleId, String source, String destination, String takeoffDate, String landingDate,
		String companyName, String landingTime, String takeoffTime, double price, int avalable_Seat) {
	super();
	SheduleId = sheduleId;
	this.source = source;
	this.destination = destination;
	this.takeoffDate = takeoffDate;
	this.landingDate = landingDate;
	CompanyName = companyName;
	this.landingTime = landingTime;
	this.takeoffTime = takeoffTime;
	this.price = price;
	this.avalable_Seat = avalable_Seat;
}




	public SerchFlightDto(int sheduleId, String source, String destination, String takeoffDate, String landingDate,
			String companyName, String landingTime, String takeoffTime, double price) {
		super();
		SheduleId = sheduleId;
		this.source = source;
		this.destination = destination;
		this.takeoffDate = takeoffDate;
		this.landingDate = landingDate;
		CompanyName = companyName;
		this.landingTime = landingTime;
		this.takeoffTime = takeoffTime;
		this.price = price;
	}

	public int getSheduleId() {
		return SheduleId;
	}

	public void setSheduleId(int sheduleId) {
		SheduleId = sheduleId;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTakeoffDate() {
		return takeoffDate;
	}
	public void setTakeoffDate(String takeoffDate) {
		this.takeoffDate = takeoffDate;
	}
	public String getLandingDate() {
		return landingDate;
	}
	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getLandingTime() {
		return landingTime;
	}
	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}
	public String getTakeoffTime() {
		return takeoffTime;
	}
	public void setTakeoffTime(String takeoffTime) {
		this.takeoffTime = takeoffTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	

	public int getAvalable_Seat() {
		return avalable_Seat;
	}




	public void setAvalable_Seat(int avalable_Seat) {
		this.avalable_Seat = avalable_Seat;
	}




	@Override
	public String toString() {
		return "SerchFlightDto [SheduleId=" + SheduleId + ", source=" + source + ", destination=" + destination
				+ ", takeoffDate=" + takeoffDate + ", landingDate=" + landingDate + ", CompanyName=" + CompanyName
				+ ", landingTime=" + landingTime + ", takeoffTime=" + takeoffTime + ", price=" + price
				+ ", avalable_Seat=" + avalable_Seat + "]";
	}




	
	
}
