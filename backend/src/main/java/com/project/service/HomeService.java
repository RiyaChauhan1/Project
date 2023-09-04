package com.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FlightDao;
import com.project.dao.PriceDao;
import com.project.dao.RouteDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dao.UserDao;
import com.project.dto.SearchFlight;
import com.project.dto.SerchFlightDto;
import com.project.dto.UserDto;
import com.project.entities.Flight;
import com.project.entities.Price;
import com.project.entities.Route;
import com.project.entities.ScheduleFlight;



@Transactional
@Service
public class HomeService 
{
	@Autowired
	private RouteDao routeDao;
	@Autowired
	private ScheduleFlightDao shedFlightDao;
	@Autowired
	private PriceDao priceDao;

	

	//@SuppressWarnings({ "unused" })
	public List<SerchFlightDto> searchFlight(SearchFlight serchInfo) {
		String s1=serchInfo.getDate();
		
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss");
		Date d1=null;
		try {
			d1 = sdf.parse(s1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	    ArrayList<SerchFlightDto> al=new ArrayList<SerchFlightDto>();
	    List<SerchFlightDto> flights = null;
		List<ScheduleFlight> flightOpt = null;

	    System.out.println("before Dao");
		flightOpt = shedFlightDao.findByTakeoffDate(d1);
		if(flightOpt ==null) {
			return null;
		}
		else {
		//ScheduleFlight sf= flightOpt.orElse(null);
		for (ScheduleFlight sf : flightOpt) 
		{  
			System.out.println("in for loop");
			if(sf.getRouteSchedule().getSource().equals(serchInfo.getSource())) //source compaire
			{
				System.out.println("in source");
				if(sf.getRouteSchedule().getDestination().equals(serchInfo.getDestination()))//destination compaire
				{
					System.out.println("in destination");
						System.out.println("class");
						SerchFlightDto serchFlightDto=new SerchFlightDto();
						serchFlightDto.setSheduleId(sf.getScheduleId());
						serchFlightDto.setSource(sf.getRouteSchedule().getSource());
						serchFlightDto.setDestination(sf.getRouteSchedule().getDestination());
						String d3 =sdf.format(sf.getTakeoffDate());
						serchFlightDto.setTakeoffDate(d3);
						String d4 =sdf.format(sf.getLandingDate());
						serchFlightDto.setLandingDate(d4);
						String t1 =sdf1.format(sf.getTakeoffTime());
						serchFlightDto.setTakeoffTime(t1);
						String t2 =sdf1.format(sf.getLandingTime());
						serchFlightDto.setLandingTime(t2);
						serchFlightDto.setCompanyName(sf.getFlightschedule().getCompanyName());
						System.out.println("after setter");

					//===================================================================================
						//set price   and avalable seat
					//==============================================================================
//						Optional<Route> routePrice=routeDao.findById(sf.getRouteSchedule().getRouteId());
//						Route flight =routePrice.orElse(null);
						List<Price> allPrice =priceDao.findAll();
						for(Price rp : allPrice)
						{
							if(sf.getFlightschedule().getFlightId() == rp.getFlight().getFlightId())
							{
								if(sf.getRouteSchedule().getRouteId() == rp.getRoute().getRouteId())
								{
									System.out.println("aaaaaaa");
						    	   if(serchInfo.getClassType().equals("economy")) 
						 	       {
						 		      serchFlightDto.setPrice(rp.getEconomyClassPrice());
							          serchFlightDto.setAvalable_Seat(sf.getAvailable_economyClass_seat());				    
							       }
						    	  if(serchInfo.getClassType().equals("business"))
							      {
							          serchFlightDto.setPrice(rp.getBusinessClassPrice());
						        	  serchFlightDto.setAvalable_Seat(sf.getAvailable_businessClass_seat());
						          }
						     	  if(serchInfo.getClassType().equals("first"))
						      	  {
						     		serchFlightDto.setPrice(rp.getFirstClassPrice());
						     		serchFlightDto.setAvalable_Seat(sf.getAvailable_firstClass_seat());
						    	  }
								}
							}
						}
					//==============================================================================	
						if(serchFlightDto !=null)
							  al.add(serchFlightDto);                 //adding serched flight in list
						System.out.println("after add");
					
				   }
			    }				
		   }
		}
	
		return al;
	}
}
