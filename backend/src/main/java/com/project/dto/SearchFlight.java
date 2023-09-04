package com.project.dto;

import java.util.Date;

public class SearchFlight {

	private String source;
	private String destination;
	private String date;
	private String classType;
	private int noOfSeat;
	
	public SearchFlight() {
		
	}

	public SearchFlight(String source, String destination, String date, String classType, int noOfSeat) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.classType = classType;
		this.noOfSeat = noOfSeat;
	}
	

	public SearchFlight(String source, String destination, String date, String classType) {
		super();
		this.source = source;
		this.destination = destination;
		this.date = date;
		this.classType = classType;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getNoOfSeat() {
		return noOfSeat;
	}

	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}

	@Override
	public String toString() {
		return "SearchFlight [source=" + source + ", destination=" + destination + ", date=" + date + ", classType="
				+ classType + ", noOfSeat=" + noOfSeat + "]";
	}

	
	
}
