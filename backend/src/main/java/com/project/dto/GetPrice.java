package com.project.dto;

public class GetPrice 
{
	
	private int flightId;
	private int routeId;
	private double businessClassPrice;
	private double economyClassPrice;
	private double firstClassPrice;
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
	public double getBusinessClassPrice() {
		return businessClassPrice;
	}
	public void setBusinessClassPrice(double businessClassPrice) {
		this.businessClassPrice = businessClassPrice;
	}
	public double getEconomyClassPrice() {
		return economyClassPrice;
	}
	public void setEconomyClassPrice(double economyClassPrice) {
		this.economyClassPrice = economyClassPrice;
	}
	public double getFirstClassPrice() {
		return firstClassPrice;
	}
	public void setFirstClassPrice(double firstClassPrice) {
		this.firstClassPrice = firstClassPrice;
	}
	@Override
	public String toString() {
		return "GetPrice [flightId=" + flightId + ", routeId=" + routeId + ", businessClassPrice=" + businessClassPrice
				+ ", economyClassPrice=" + economyClassPrice + ", firstClassPrice=" + firstClassPrice + "]";
	}
	
}
