package com.project.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="price")
public class Price 
{
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int priceId  ;
	
	@ManyToOne
	@JoinColumn(name="flightId")
	private Flight flight;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="routeId")
	private Route route;
	
	private double businessClassPrice;
	private double economyClassPrice;
	private double firstClassPrice;
	
	public Price() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Price(int priceId, Flight flight, Route route, double businessClassPrice, double economyClassPrice,
			double firstClassPrice) {
		super();
		this.priceId = priceId;
		this.flight = flight;
		this.route = route;
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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
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
		return "Price [priceId=" + priceId + ", flight=" + flight + ", route=" + route + ", businessClassPrice="
				+ businessClassPrice + ", economyClassPrice=" + economyClassPrice + ", firstClassPrice="
				+ firstClassPrice + "]";
	}


	

	
	
	
	
}
