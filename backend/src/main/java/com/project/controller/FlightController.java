package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.GetFlight;
import com.project.dto.Response;
import com.project.dto.UserDto;
import com.project.entities.Flight;
import com.project.service.FlightService;

@CrossOrigin(origins = "*")
@RestController
public class FlightController
{
	@Autowired
	FlightService service;
	@PostMapping("flight/add")
	public ResponseEntity<?> addFlight(@RequestBody Flight f)
	{
		Flight result=service.addFlight(f);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
	@GetMapping("flight/getAll")
	public ResponseEntity<?> getAllFlight()
	{
		ArrayList<GetFlight> result=service.getAllFlightDetails();
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
	
	@DeleteMapping("/flight/delete/{id}")
	public ResponseEntity<?> deleteFlight(@PathVariable int id)
	{
		int result=service.deleteById(id);
		if(result!=1)
		{
			return Response.error("flight not found");
		}
		return Response.success(result);
	}
	
	@PutMapping("flight/modify/{id}")
	public ResponseEntity<?> modifyFlight(@PathVariable("id") int id,@RequestBody GetFlight f)
	{
		
	Flight flight= service.findById(id);
	
		flight.setAirlineName(f.getAirlineName());
		flight.setCompanyName(f.getCompanyName());
		flight.setEconomyClassSeats(f.getEconomyClassSeats());
		flight.setBuisnessClassSeats(f.getBuisnessClassSeats());
		flight.setFirstClassSeats(f.getFirstClassSeats());
		flight.setCabinBaggageCapacity(f.getCabinBaggageCapacity());
		flight.setCheckinBaggageCapacity(f.getCheckinBaggageCapacity());
	
		Flight result=service.modifyFlight(flight);
		if(result==null)
		{
			return Response.error("flight not found");
		}
		return Response.success(result);
	}
	


}
