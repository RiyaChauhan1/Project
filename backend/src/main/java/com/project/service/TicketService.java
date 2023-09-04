package com.project.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.BookingDao;
import com.project.dao.PassengerDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dao.UserDao;
import com.project.dto.TicketDTO;
import com.project.dto.TicketMethodDTO;
import com.project.dto.TicketOutDTO;
import com.project.entities.Bookings;
import com.project.entities.Passenger;
import com.project.entities.Price;
import com.project.entities.ScheduleFlight;
import com.project.entities.User;

@Transactional
@Service
public class TicketService {

	@Autowired
	private ScheduleFlightDao shedFlightDao;
	@Autowired
	private PassengerDao passengerDao;
	
	@Autowired
	private ScheduleFlightDao schedDao;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private BookingDao bookingDao;
	
	private TicketMethodDTO ticketMethodDTO;
	
	public TicketOutDTO generateTicket(TicketDTO t) 
	{
		List<Price> pr =null;
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1=new SimpleDateFormat("hh:mm:ss");
		System.out.println("before Service");
		
		Optional<ScheduleFlight> schedFlight =	shedFlightDao.findById(t.getScheduleId());
		ScheduleFlight sf=schedFlight.orElse(null);
//======================================================================================================================
		Bookings bk=new Bookings();
		
		bk.setBookingStatus("Booked");
		bk.setPaymentStatus("Pay");
		//========================
		//set seat no
		//========================
		int e= sf.getFlightschedule().getEconomyClassSeats() + 1;
		int b1=sf.getFlightschedule().getBuisnessClassSeats();
     	int f=sf.getFlightschedule().getFirstClassSeats();

		
		if(t.getSeatType().equals("economy")) 
		{
			int e2=sf.getAvailable_economyClass_seat();
			bk.setSeatNo(e-e2);
		}
		else if(t.getSeatType().equals("business"))
		 {
			 int b2 = e + b1  ;
			 int b3=sf.getAvailable_businessClass_seat();
			 bk.setSeatNo(b2-b3);
		 }
		else if(t.getSeatType().equals("first"))
		{
			int f2 = e + b1 + f ;
			int f3=sf.getAvailable_firstClass_seat();
			bk.setSeatNo(f2-f3);
		}
	//	=================
	//	=================
		
		pr=sf.getFlightschedule().getPriceList();
		System.out.println("before price");
		System.out.println(t.getSeatType());
		for(Price pr1 :pr)                 // for price seeting
		{
			//if(sf.getRouteSchedule().getRouteId() == pr1.getRoute().getRouteId())
			//{
			if(sf.getFlightschedule().getFlightId() == pr1.getFlight().getFlightId())
			{
				System.out.println("if");
				if(t.getSeatType().equals("economy"))
				    bk.setTotalAmount(pr1.getEconomyClassPrice());
				else if(t.getSeatType().equals("business"))
				{
                    bk.setTotalAmount(pr1.getBusinessClassPrice());
                    System.out.println("business");
				}
				else if(t.getSeatType().equals("first"))
					 bk.setTotalAmount(pr1.getFirstClassPrice());		
			}
		}
		System.out.println("after price");
		Optional<Passenger> p=passengerDao.findById(t.getPassengerId());
		
		Passenger p1=p.orElse(null);
		//System.out.println(p1.getPassengerName());
		bk.setPassenger(p1);
		System.out.println("afte passenger");
		Optional<ScheduleFlight> sf1=schedDao.findById(t.getScheduleId());
		ScheduleFlight schedF1=sf1.orElse(sf);
		bk.setScheduleFlight(schedF1);
		
		System.out.println("after user");
		Optional<User> u=userDao.findById(t.getUserId());
		User user=u.orElse(null);
		bk.setUser(user);
		
		Bookings b= bookingDao.save(bk);
		
//    	  Bookings b=ticketMethodDTO.saveBooking(sf, t);
//=======================================================================
		// update schedule dao
//======================================================================
		if(t.getSeatType().equals("economy")) 
		{
			int e5=sf.getAvailable_economyClass_seat();
			sf.setAvailable_economyClass_seat(e5-1);
		}
		else if(t.getSeatType().equals("business"))
		 {
			    int b5=sf.getAvailable_businessClass_seat();
				sf.setAvailable_businessClass_seat(b5-1);
		 }
		else if(t.getSeatType().equals("first"))
		{
			int f5=sf.getAvailable_firstClass_seat();
			sf.setAvailable_firstClass_seat(f5-1);	
		}
		    
		ScheduleFlight s=schedDao.save(sf);
		System.out.println(s.getAvailable_economyClass_seat());

//========================================================================
//========================================================================	
		//ticketMethodDTO.updateScheduleFlight(sf, t);
		
		TicketOutDTO ticketOutDTO =new TicketOutDTO();
		
		ticketOutDTO.setAirlineName(sf.getFlightschedule().getAirlineName());
		ticketOutDTO.setCompanyName(sf.getFlightschedule().getCompanyName());
		ticketOutDTO.setSource(sf.getRouteSchedule().getSource());
		ticketOutDTO.setDestination(sf.getRouteSchedule().getDestination());
		  String ldate =sdf.format(sf.getLandingDate());
		ticketOutDTO.setLandingDate(ldate);
		  String lTime=sdf1.format(sf.getLandingTime());
		ticketOutDTO.setLandingTime(lTime);
		  String ldate1 =sdf.format(sf.getTakeoffDate());
		ticketOutDTO.setTakeoffDate(ldate1);
		  String lTime1=sdf1.format(sf.getTakeoffTime());
		ticketOutDTO.setTakeoffTime(lTime1);
		ticketOutDTO.setSeatNo(b.getSeatNo());
		ticketOutDTO.setPassengerName(b.getPassenger().getPassengerName());
		
		
	
    	return ticketOutDTO;
	
	}
	
}
