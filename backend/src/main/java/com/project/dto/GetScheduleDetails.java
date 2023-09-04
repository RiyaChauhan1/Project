package com.project.dto;

public class GetScheduleDetails {
	private int flightId;
	private int routeId;
	private String takeoffDate;
	private String takeoffTime;
	private String landingDate;
	private String landingTime;
	
	public GetScheduleDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GetScheduleDetails(int flightId, int routeId, String takeoffDate, String takeoffTime, String landingDate,
			String landingTime) {
		super();
		this.flightId = flightId;
		this.routeId = routeId;
		this.takeoffDate = takeoffDate;
		this.takeoffTime = takeoffTime;
		this.landingDate = landingDate;
		this.landingTime = landingTime;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getTakeoffDate() {
		return takeoffDate;
	}

	public void setTakeoffDate(String takeoffDate) {
		this.takeoffDate = takeoffDate;
	}

	public String getTakeoffTime() {
		return takeoffTime;
	}

	public void setTakeoffTime(String takeoffTime) {
		this.takeoffTime = takeoffTime;
	}

	public String getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	@Override
	public String toString() {
		return "GetScheduleDetails [flightId=" + flightId + ", routeId=" + routeId + ", takeoffDate=" + takeoffDate
				+ ", takeoffTime=" + takeoffTime + ", landingDate=" + landingDate + ", landingTime=" + landingTime
				+ "]";
	}
	
	

}