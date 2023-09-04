package com.project.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.dto.CustomException;
import com.project.dto.GetFlight;
import com.project.dto.GetScheduleDetails;
import com.project.dto.Response;
import com.project.dto.ScheduleDetails;
import com.project.entities.Flight;
import com.project.entities.ScheduleFlight;
import com.project.service.ScheduleService;


@CrossOrigin(origins = "*")
@Controller
public class ScheduleFlightController  {

	@Autowired
	private ScheduleService scheduleService;
	
	@JsonIgnore
	@PostMapping("/schedule/add")
	public ResponseEntity<?> addFlightInSchedule(@RequestBody GetScheduleDetails sd  )  
	{
		
		ScheduleFlight sf=scheduleService.addSchedule(sd);
		
		if(sf==null)
		 {
			return Response.error("you did not set the price for that route");
     	 }
		return Response.success("flight schedule sucessfully");		
				
	}
	@GetMapping("/schedule/get")
	public ResponseEntity<?> getFlightInSchedule( )  
	{
		
		List<ScheduleDetails > result=scheduleService.getSchedule();		
		if(result==null)
		 {
			return Response.error("user not found");
     	 }
		return Response.success(result);		
				
	}
	
	@DeleteMapping("/schedule/delete/{id}")
	public ResponseEntity<?> deleteFlight(@PathVariable int id)
	{
		
	
		
		int result=scheduleService.deleteById(id);
		if(result!=1)
		{
			return Response.error("Schedule not found");
		}
		return Response.success(result);
	}
	//edit schedule
	@PutMapping("schedule/modify/{id}")
	public ResponseEntity<?> modifyFlight(@PathVariable("id") int id,@RequestBody GetScheduleDetails sd)
	{
		ScheduleFlight result=scheduleService.modifySchedule(sd,id);
		if(result==null)
		{
			return Response.error("fail to modify schedule");
		}
		return Response.success("modified sucessflly");
	}
}
