package com.project.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ScheduleDetails 
{
	private int scheduleId;
	private String airlineName;
	private String source;
	private String destination;
	@Temporal(TemporalType.DATE)
	private Date takeoffDate;
	@Temporal(TemporalType.DATE)
	private Date landingDate;

	@Temporal(TemporalType.TIME)
	private Date takeoffTime;
	@Temporal(TemporalType.TIME)
	private Date landingTime;
	public ScheduleDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ScheduleDetails(String airlineName, String source, String destination, Date takeoffDate, Date landingDate,
			Date takeoffTime, Date landingTime) {
		super();
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.takeoffDate = takeoffDate;
		this.landingDate = landingDate;
		this.takeoffTime = takeoffTime;
		this.landingTime = landingTime;
	}

	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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
	public Date getTakeoffDate() {
		return takeoffDate;
	}
	public void setTakeoffDate(Date takeoffDate) {
		this.takeoffDate = takeoffDate;
	}
	public Date getLandingDate() {
		return landingDate;
	}
	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}
	public Date getTakeoffTime() {
		return takeoffTime;
	}
	public void setTakeoffTime(Date takeoffTime) {
		this.takeoffTime = takeoffTime;
	}
	public Date getLandingTime() {
		return landingTime;
	}
	public void setLandingTime(Date landingTime) {
		this.landingTime = landingTime;
	}

}

