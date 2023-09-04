package com.project.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="route")
public class Route 
{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int routeId;
	private String source;
	private String destination;
	
	
	@OneToMany(mappedBy ="route")
	private List<Price> priceList;
	
	//@JsonIgnore
	@OneToMany(mappedBy="routeSchedule")
	private List<ScheduleFlight> scheduleFlight;
	
	public Route() {
		super();
		
	}

	public Route(int routeId, String source, String destination) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
	}

	public Route(int routeId, String source, String destination, List<Price> priceList,
			List<ScheduleFlight> scheduleFlight) {
		super();
		this.routeId = routeId;
		this.source = source;
		this.destination = destination;
		this.priceList = priceList;
		this.scheduleFlight = scheduleFlight;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", source=" + source + ", destination=" + destination + ", priceList="
				+ priceList + ", scheduleFlight=" + scheduleFlight + "]";
	}

	
	

}
