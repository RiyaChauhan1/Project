package com.project.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.dao.FlightDao;
import com.project.dao.RouteDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dto.GetScheduleDetails;
import com.project.entities.Flight;
import com.project.entities.Route;
import com.project.entities.ScheduleFlight;

public class AdminService {
	@Autowired
	FlightDao fdao;
	@Autowired
	RouteDao rDao;
	@Autowired
	private ScheduleFlightDao schedDao;

	public ScheduleFlight addFlightInSchedule(GetScheduleDetails sd) 
	{
		  ScheduleFlight s=new ScheduleFlight();

			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss");
			
			
			Optional<Flight> addedFlight =fdao.findById(sd.getFlightId());
			Flight f= addedFlight.orElse(null);
			s.setFlightschedule(f);
			Optional<Route> r =rDao.findById(sd.getRouteId());
		    Route route=r.orElse(null);
		    s.setScheduleId(11);
			s.setRouteSchedule(route);
			s.setAvailable_businessClass_seat(f.getBuisnessClassSeats());
			s.setAvailable_economyClass_seat(f.getEconomyClassSeats());
			s.setAvailable_firstClass_seat(f.getEconomyClassSeats());
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
			s.setTakeoffDate(ldate);
			Date tTime=null;
			try {
			 tTime =sdf.parse(sd.getTakeoffTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			s.setTakeoffTime(tTime);
			
			Date lTime=null;
			try {
			 lTime =sdf.parse(sd.getLandingTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			s.setLandingTime(lTime);
			
			ScheduleFlight result =null;
			try {
				 result=schedDao.save(s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println(result.getAvailable_businessClass_seat());
				
		return null;
	}

	public ScheduleFlight addFlightInSchedule(ScheduleFlight s) {
		ScheduleFlight s1= schedDao.save(s);
		return s1;
	}

	

}
