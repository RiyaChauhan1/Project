package com.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FlightDao;
import com.project.dao.PriceDao;
import com.project.dao.RouteDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dto.GetScheduleDetails;
import com.project.dto.ScheduleDetails;
import com.project.entities.Flight;
import com.project.entities.Price;
import com.project.entities.Route;
import com.project.entities.ScheduleFlight;





@Transactional
@Service
public class ScheduleService 
{
	@Autowired
	FlightDao fdao;
	@Autowired
	RouteDao rDao;
	@Autowired
	private ScheduleFlightDao schedDao;
	@Autowired
	private PriceDao priceDao;

	
	
	//	 SAGAR : code to add  Schedule 
	public ScheduleFlight addSchedule(GetScheduleDetails sd)
	{
		ScheduleFlight s=new ScheduleFlight();

		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm");
		
		List<Price> allPrice =priceDao.findAll();
		
		int sd_routeId =sd.getRouteId();
		int sd_flightId=sd.getFlightId();
		
		for(Price price : allPrice)
		{
			int priceFlightId =price.getFlight().getFlightId();
			System.out.println("aaaaa");
			System.out.println(priceFlightId);
			
			int priceRouteId =price.getRoute().getRouteId();
			System.out.println(priceRouteId);
			if(sd_flightId == priceFlightId);
			{  
				if(sd_routeId == priceRouteId)
				{
     				System.out.println("before find");
					Optional<Flight> addedFlight =fdao.findById(sd.getFlightId());
					Flight f= addedFlight.orElse(null);
					s.setFlightschedule(f);
					System.out.println("afterr find");
					
					System.out.println("route");
					Optional<Route> r =rDao.findById(sd.getRouteId());
				    Route route=r.orElse(null);
				    System.out.println(route.getDestination());

				    s.setRouteSchedule(route);
				   // System.out.println(route);
				    System.out.println("after route");
			//=======================================================================
				   // s.setScheduleId(11);
					s.setAvailable_businessClass_seat(f.getBuisnessClassSeats());
					System.out.println(s.getAvailable_businessClass_seat());
					s.setAvailable_economyClass_seat(f.getEconomyClassSeats());
					System.out.println(s.getAvailable_economyClass_seat());
					s.setAvailable_firstClass_seat(f.getEconomyClassSeats());
					System.out.println(s.getAvailable_firstClass_seat());
					//======================================================
					Date tdate = null;
					try {
						tdate = sdf.parse(sd.getTakeoffDate());
					  } catch (ParseException e) {
						e.printStackTrace();
					  }
					s.setTakeoffDate(tdate);
						
					Date ldate = null;
					try {
						  ldate = sdf.parse(sd.getLandingDate());
					    } catch (ParseException e) {
						e.printStackTrace();
				    	}
					s.setLandingDate(ldate);
					
					Date tTime=null;
					try {
					 tTime =sdf1.parse(sd.getTakeoffTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					s.setTakeoffTime(tTime);
					
					Date lTime=null;
					try {
					 lTime =sdf1.parse(sd.getLandingTime());
					} catch (ParseException e) {
						e.printStackTrace();
					}
					s.setLandingTime(lTime);
					//=========================================
					
					ScheduleFlight sf=schedDao.save(s);  ///save flight in schedule
					
					return sf;
				}
			}
		}
		
		return null;
		
	}
	//get schedule list sagar
	public List<ScheduleDetails> getSchedule()
	{
		List<ScheduleFlight> schedules=schedDao.findAll();
		List<ScheduleDetails> list=new ArrayList<>();
		for(ScheduleFlight sch:schedules)
		{
			ScheduleDetails temp=new ScheduleDetails();
			{
				temp.setScheduleId(sch.getScheduleId());
				temp.setAirlineName(sch.getFlightschedule().getAirlineName());
				temp.setSource(sch.getRouteSchedule().getSource());
				temp.setDestination(sch.getRouteSchedule().getDestination());
				temp.setTakeoffDate(sch.getTakeoffDate());
				temp.setLandingDate(sch.getLandingDate());
				temp.setTakeoffTime(sch.getTakeoffTime());
				temp.setLandingTime(sch.getLandingTime());
			}
			list.add(temp);
		}
		return list;
	}
	
	public int deleteById(int id) 
	{
		schedDao.deleteById(id);
		return 1;
	}
	public ScheduleFlight modifySchedule(GetScheduleDetails sd,int id)
	{
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm");
		
		ScheduleFlight schedule=schedDao.getById(id);
		
		Date tdate = null;
		try {
			tdate = sdf.parse(sd.getTakeoffDate());
		  } catch (ParseException e) {
			e.printStackTrace();
		  }
		schedule.setTakeoffDate(tdate);
			
		Date ldate = null;
		try {
			  ldate = sdf.parse(sd.getLandingDate());
		    } catch (ParseException e) {
			e.printStackTrace();
	    	}
		schedule.setLandingDate(ldate);
		
		Date tTime=null;
		try {
		 tTime =sdf1.parse(sd.getTakeoffTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		schedule.setTakeoffTime(tTime);
		
		Date lTime=null;
		try {
		 lTime =sdf1.parse(sd.getLandingTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		schedule.setLandingTime(lTime);
//		
//		schedule.setLandingDate(sd.getLandingDate());
//		schedule.setTakeoffDate(sd.getTakeoffDate());
//		schedule.setLandingTime(sd.getLandingTime());
//		schedule.setTakeoffTime(sd.getTakeoffTime());
		return schedDao.save(schedule);
	}

}
