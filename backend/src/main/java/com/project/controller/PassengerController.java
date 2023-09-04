package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.PassengerDeleteDto;
import com.project.dto.PassengerInputDto;
import com.project.dto.PassengerOutDto;
import com.project.dto.Response;
import com.project.entities.Passenger;
import com.project.service.PassengerService;

@CrossOrigin(origins = "*")
@RestController
public class PassengerController 
{
	@Autowired
	private PassengerService passengerService;
	
	@PostMapping("/passenger/info")
	public ResponseEntity<?> addPssengerInfo(@RequestBody PassengerInputDto p)
	{
		
		System.out.println("in user signup user :"+p);
		Passenger result=passengerService.addPassenger(p);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
	
	@DeleteMapping("/passenger/delete/{id}")
	public ResponseEntity<?> deletePassenger(@PathVariable int id)
	{
		
		System.out.println("in user signup user :"+id);
		
		int result=passengerService.deleteById(id);
		if(result!=1)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
	
	
	
	
	@GetMapping("/passenger/edit/{id}")
	public ResponseEntity<?> beforeeditPassenger(@PathVariable int id)
	{
		System.out.println("in user signup user :"+id);
		Passenger result=passengerService.findById(id);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}

	@PutMapping("/passenger/edit/after")
	public ResponseEntity<?> afterEditPassenger(@RequestBody Passenger p)
	{
		System.out.println("in user signup user :"+p);
		Passenger result=passengerService.savePassenger(p);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}

}
