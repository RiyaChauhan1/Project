package com.project.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name= "flight")
public class Flight 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int flightId;
	private String airlineName;
	private String companyName;
	private int economyClassSeats;
	private int buisnessClassSeats;
	private int firstClassSeats;
	private int checkinBaggageCapacity;
	private int cabinBaggageCapacity;
//	@JsonIgnore
//	@JsonIgnoreProperties(value = {
//		    "priceList",
//		    "scheduleFlight"
//		})
	@OneToMany(mappedBy ="flight")
	private List<Price> priceList;
	//@JsonIgnore
	@OneToMany(mappedBy="flightschedule")
	private List<ScheduleFlight> scheduleFlight;
	
	
	public Flight() {
		super();
		
	}



	public Flight(int flightId, String airlineName, String companyName, int economyClassSeats, int buisnessClassSeats,
			int firstClassSeats, int checkinBaggageCapacity, int cabinBaggageCapacity, List<Price> priceList,
			List<ScheduleFlight> scheduleFlight) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.companyName = companyName;
		this.economyClassSeats = economyClassSeats;
		this.buisnessClassSeats = buisnessClassSeats;
		this.firstClassSeats = firstClassSeats;
		this.checkinBaggageCapacity = checkinBaggageCapacity;
		this.cabinBaggageCapacity = cabinBaggageCapacity;
		this.priceList = priceList;
		this.scheduleFlight = scheduleFlight;
	}

	public int getFlightId() {
		return flightId;
	}



	public List<Price> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Price> priceList) {
		this.priceList = priceList;
	}

	public List<ScheduleFlight> getScheduleFlight() {
		return scheduleFlight;
	}

	public void setScheduleFlight(List<ScheduleFlight> scheduleFlight) {
		this.scheduleFlight = scheduleFlight;
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

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", airlineName=" + airlineName + ", companyName=" + companyName
				+ ", economyClassSeats=" + economyClassSeats + ", buisnessClassSeats=" + buisnessClassSeats
				+ ", firstClassSeats=" + firstClassSeats + ", checkinBaggageCapacity=" + checkinBaggageCapacity
				+ ", cabinBaggageCapacity=" + cabinBaggageCapacity + ", priceList=" + priceList + ", scheduleFlight="
				+ scheduleFlight + "]";
	}



	



	
	
	
	

	
}
