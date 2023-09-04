package com.project.dto;

public class PassengerDeleteDto 
{
	private int id;

	public PassengerDeleteDto(int id) {
		
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PassengerDeleteDto [id=" + id + "]";
	}
	

}
