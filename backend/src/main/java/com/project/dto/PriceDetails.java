package com.project.dto;

public class PriceDetails
{

	private int priceId;
	private String airlineName;
	private String source;
	private String destination;
	private double businessClassPrice;
	private double economyClassPrice;
	private double firstClassPrice;
	public String getAirlineName() {
		return airlineName;
	}
	public PriceDetails() {
		// TODO Auto-generated constructor stub
	}
	public PriceDetails(int priceId, String airlineName, String source, String destination, double businessClassPrice,
			double economyClassPrice, double firstClassPrice) {
		super();
		this.priceId = priceId;
		this.airlineName = airlineName;
		this.source = source;
		this.destination = destination;
		this.businessClassPrice = businessClassPrice;
		this.economyClassPrice = economyClassPrice;
		this.firstClassPrice = firstClassPrice;
	}

	public int getPriceId() {
		return priceId;
	}

	public void setPriceId(int priceId) {
		this.priceId = priceId;
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
	
}
