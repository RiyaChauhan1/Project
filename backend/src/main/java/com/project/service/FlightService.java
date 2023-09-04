package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.FlightDao;
import com.project.dao.PriceDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dto.GetFlight;
import com.project.entities.Flight;

@Transactional
@Service
public class FlightService 
{
	@Autowired
	FlightDao fdao;
	@Autowired
	PriceDao pdao;
	@Autowired
	ScheduleFlightDao sdao;
	
	public Flight addFlight(Flight f)
	{
		Flight addedFlight =fdao.save(f);
		
		return addedFlight;
	}
	//edited
	public ArrayList<GetFlight> getAllFlightDetails()
	{
		List<Flight> flightList= fdao.findAll();
		ArrayList<GetFlight> list=new ArrayList<GetFlight>(); 
		for(Flight f: flightList)
		{
			
			GetFlight temp=new GetFlight();
			
			temp.setFlightId(f.getFlightId());
		    temp.setAirlineName(f.getAirlineName());
		    temp.setCompanyName(f.getCompanyName());
			temp.setEconomyClassSeats(f.getEconomyClassSeats());
		    temp.setBuisnessClassSeats(f.getBuisnessClassSeats());
		    temp.setFirstClassSeats(f.getFirstClassSeats());
			temp.setCabinBaggageCapacity(f.getCabinBaggageCapacity());
		    temp.setCheckinBaggageCapacity(f.getCheckinBaggageCapacity());
		    
		    list.add(temp);	
		}

		return list;
	}

	public Flight findById(int id)
	{
		Optional<Flight> addedFlight =fdao.findById(id);
		Flight f= addedFlight.orElse(null);
		
		return f;
	}
	public int deleteById(int id) 
	{

		
		Flight flight=findById(id);
		sdao.deleteAllInBatch(flight.getScheduleFlight());
		pdao.deleteAllInBatch(flight.getPriceList());
		
		fdao.delete(flight);
		return 1;
	}

	public Flight modifyFlight(Flight f) 
	{
		
		return fdao.save(f);
		
	}
}
