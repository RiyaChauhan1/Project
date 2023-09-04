package com.project.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dao.BookingDao;
import com.project.dao.PassengerDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dao.UserDao;
import com.project.entities.Bookings;
import com.project.entities.Passenger;
import com.project.entities.Price;
import com.project.entities.ScheduleFlight;
import com.project.entities.User;

@Component
public class TicketMethodDTO 
{
//	@Autowired
//	private PassengerDao passengerDao;
//	@Autowired
//	private ScheduleFlightDao schedDao;
//	@Autowired
//	private UserDao userDao;
//	@Autowired
//	private BookingDao bookingDao;
//	
//	public Bookings saveBooking (ScheduleFlight sf, TicketDTO t)
//	{
//		        List<Price> pr =null;
//				Bookings bk=new Bookings();
//				
//				bk.setBookingStatus("Booked");
//				bk.setPaymentStatus("Pay");
//				if(t.getSeatType().equals("economy")) 
//				{
//					int f=sf.getAvailable_economyClass_seat();
//					int f2=51-f;
//					System.out.println(f2);	
//				}
//				if(t.getSeatType().equals("business"))
//				 {
//					 int fb=sf.getAvailable_businessClass_seat();
//						int fb1=fb-1;
//						System.out.println(fb1);
//						bk.setSeatNo(fb1);
//				 }
//				if(t.getSeatType().equals("first"))
//				{
//					int f1=sf.getAvailable_firstClass_seat();
//					int f3=f1-1;
//					System.out.println(f3);
//					bk.setSeatNo(f3);	
//				}
//				
//				pr=sf.getFlightschedule().getPriceList();
//				System.out.println("before price");
//				System.out.println(t.getSeatType());
//				for(Price pr1 :pr)
//				{
//					//if(sf.getRouteSchedule().getRouteId() == pr1.getRoute().getRouteId())
//					//{
//					if(sf.getFlightschedule().getFlightId() == pr1.getFlight().getFlightId())
//					{
//						System.out.println("if");
//						if(t.getSeatType().equals("economy"))
//						    bk.setTotalAmount(pr1.getEconomyClassPrice());
//						if(t.getSeatType().equals("business"))
//						{
//		                    bk.setTotalAmount(pr1.getBusinessClassPrice());
//		                    System.out.println("business");
//						}
//						if(t.getSeatType().equals("first"))
//							 bk.setTotalAmount(pr1.getFirstClassPrice());		
//					}
//				}
//				System.out.println("after price");
//				Optional<Passenger> p=passengerDao.findById(t.getPassengerId());
//				
//				Passenger p1=p.orElse(null);
//				//System.out.println(p1.getPassengerName());
//				bk.setPassenger(p1);
//				System.out.println("afte passenger");
//				Optional<ScheduleFlight> sf1=schedDao.findById(t.getScheduleId());
//				ScheduleFlight schedF1=sf1.orElse(sf);
//				bk.setScheduleFlight(schedF1);
//				
//				System.out.println("after user");
//				Optional<User> u=userDao.findById(t.getUserId());
//				User user=u.orElse(null);
//				bk.setUser(user);
//				
//				Bookings b= bookingDao.save(bk);
//		return b;
//	
//		if(t.getSeatType().equals("economy")) 
//		{
//			int f=sf.getAvailable_economyClass_seat();
//			int f2=f-1;
//			System.out.println(f2);
//			sf.setAvailable_economyClass_seat(f2);
//		}
//		 if(t.getSeatType().equals("business"))
//		 {
//			 int f=sf.getAvailable_businessClass_seat();
//				int f2=f-1;
//				System.out.println(f2);
//				sf.setAvailable_businessClass_seat(f2);
//		 }
//		if(t.getSeatType().equals("first"))
//		{
//
//			int f=sf.getAvailable_firstClass_seat();
//			int f2=f-1;
//			System.out.println(f2);
//			sf.setAvailable_firstClass_seat(f2);
//			
//		}
//		    
//	//		 sf.setAvailable_firstClass_seat((sf.getAvailable_firstClass_seat()-1));
//	
//		System.out.println("before after");
//		ScheduleFlight s=schedDao.save(sf);
//		System.out.println("aftr");
//		return;
//	}

}
