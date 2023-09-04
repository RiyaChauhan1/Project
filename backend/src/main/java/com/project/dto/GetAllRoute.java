package com.project.dto;

public class GetAllRoute 
{
	private int id;
	private String source;
	private String destination;
	public GetAllRoute() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public GetAllRoute(int id, String source, String destination) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
	}


	@Override
	public String toString() {
		return "getAllRoute [id=" + id + ", source=" + source + ", destination=" + destination + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}
