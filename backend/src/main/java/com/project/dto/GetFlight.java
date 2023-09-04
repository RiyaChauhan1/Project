package com.project.dto;

import com.project.entities.Flight;

public class GetFlight {
	private int flightId;
	private String airlineName;
	private String companyName;
	private int economyClassSeats;
	private int buisnessClassSeats;
	private int firstClassSeats;
	private int checkinBaggageCapacity;
	private int cabinBaggageCapacity;
	
	public GetFlight() {
		// TODO Auto-generated constructor stub
	}
	public GetFlight(int flightId, String airlineName, String companyName, int economyClassSeats,
			int buisnessClassSeats, int firstClassSeats, int checkinBaggageCapacity, int cabinBaggageCapacity) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.companyName = companyName;
		this.economyClassSeats = economyClassSeats;
		this.buisnessClassSeats = buisnessClassSeats;
		this.firstClassSeats = firstClassSeats;
		this.checkinBaggageCapacity = checkinBaggageCapacity;
		this.cabinBaggageCapacity = cabinBaggageCapacity;
	}
	public GetFlight(String airlineName, String companyName, int economyClassSeats, int buisnessClassSeats,
			int firstClassSeats, int checkinBaggageCapacity, int cabinBaggageCapacity) {
		super();
		this.airlineName = airlineName;
		this.companyName = companyName;
		this.economyClassSeats = economyClassSeats;
		this.buisnessClassSeats = buisnessClassSeats;
		this.firstClassSeats = firstClassSeats;
		this.checkinBaggageCapacity = checkinBaggageCapacity;
		this.cabinBaggageCapacity = cabinBaggageCapacity;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getEconomyClassSeats() {
		return economyClassSeats;
	}
	public void setEconomyClassSeats(int economyClassSeats) {
		this.economyClassSeats = economyClassSeats;
	}
	public int getBuisnessClassSeats() {
		return buisnessClassSeats;
	}
	public void setBuisnessClassSeats(int buisnessClassSeats) {
		this.buisnessClassSeats = buisnessClassSeats;
	}
	public int getFirstClassSeats() {
		return firstClassSeats;
	}
	public void setFirstClassSeats(int firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}
	public int getCheckinBaggageCapacity() {
		return checkinBaggageCapacity;
	}
	public void setCheckinBaggageCapacity(int checkinBaggageCapacity) {
		this.checkinBaggageCapacity = checkinBaggageCapacity;
	}
	public int getCabinBaggageCapacity() {
		return cabinBaggageCapacity;
	}
	public void setCabinBaggageCapacity(int cabinBaggageCapacity) {
		this.cabinBaggageCapacity = cabinBaggageCapacity;
	}
	
	

}
