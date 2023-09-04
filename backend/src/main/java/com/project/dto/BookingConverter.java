package com.project.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.project.entities.Bookings;
import com.project.entities.ScheduleFlight;

@Component
public class BookingConverter 
{
	public ArrayList<BookingHistoryDto> sendBookingHistory (List<Bookings> bookingList2)
	{
		ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
		
		 SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat sdf1 =new SimpleDateFormat("hh:mm:ss");
		 
		for(Bookings book: bookingList2)
	    {
	    		
	    	 BookingHistoryDto bookingDto= new BookingHistoryDto();
	     
	    	// System.out.println("abc");
	    	 bookingDto.setBookingNo(book.getBookingNo());
	    	 
	    	 bookingDto.setSource(book.getScheduleFlight().getRouteSchedule().getSource());
	    	 bookingDto.setDestination(book.getScheduleFlight().getRouteSchedule().getDestination());
	    	 bookingDto.setCompanyName(book.getScheduleFlight().getFlightschedule().getCompanyName());
	    	 bookingDto.setAirlineName(book.getScheduleFlight().getFlightschedule().getAirlineName());
	    	 
	    	 bookingDto.setBookingStatus(book.getBookingStatus());
	    	 
	    	 String startDate=sdf.format(book.getScheduleFlight().getTakeoffDate());
	    	 bookingDto.setTakeoffDate(startDate);
	    	 
	    	 String startTime=sdf1.format(book.getScheduleFlight().getTakeoffTime());
	    	 bookingDto.setTakeoffTime(startTime);
	    	
	    	 String arrivalDate=sdf.format(book.getScheduleFlight().getLandingDate());
	    	 bookingDto.setLandingDate(arrivalDate);
	    	 
	    	 String arrivaltTime=sdf1.format(book.getScheduleFlight().getTakeoffTime());
	    	 bookingDto.setLandingTime(arrivaltTime);
	    	 
	    	 bookingDto.setSeatNo(book.getSeatNo());
	    	 try {
	    		 System.out.println(book.getPassenger().getPassengerName());
		    	 bookingDto.setPassengerName(book.getPassenger().getPassengerName());
			} catch (Exception e) {
				
			}
           bookingDto.setTotalPrice(book.getTotalAmount());
           
	    	 System.out.println("before add");
	    	 if(bookingDto!=null)
	    		 bookingListDto.add(bookingDto);
	    	 System.out.println("after add");
	    	// System.out.println(bookingDto);	
	    }
		return bookingListDto;    
	}
	
}
