package com.project.service;


//

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.BookingDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dao.UserDao;
import com.project.dto.BookingConverter;
import com.project.dto.BookingHistoryDto;

import com.project.entities.Bookings;

import com.project.entities.User;

@Transactional
@Service
public class BookingService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;
	@Autowired
	private BookingConverter bookingConverter;

	 
	//@SuppressWarnings("null")
	public ArrayList<BookingHistoryDto> showUpcomingBooking(int id)
	{
		List<Bookings> bookingList= null;
	    ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
		 ArrayList<Bookings> bookingFlightList= new ArrayList<Bookings>();
		
		
		 Optional<User> u=userDao.findById(id);
		 User user=u.orElse(null);
		 bookingList=	bookingDao.findAll();
	   for(Bookings bookings: bookingList)
	    {
	    	Date date1= (bookings.getScheduleFlight().getTakeoffDate());
	    	Date date= new Date();
	    	if(user.getUserId() == bookings.getUser().getUserId() )
	    	{
	    	   if(date1.after(date))
	    	   {
	    		   bookingFlightList.add(bookings);
	    	   }
	    	}
	    }
 
	   bookingListDto=bookingConverter.sendBookingHistory(bookingFlightList);
	  return bookingListDto;
}
	
	
	public ArrayList<BookingHistoryDto> showCompletedBooking(int id)
	{
	   	List<Bookings> bookingList= null;
	     ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
		 ArrayList<Bookings> bookingFlightList= new ArrayList<Bookings>();
	
		 bookingList=	bookingDao.findAll();
	   for(Bookings bookings: bookingList)
	    {
	    	Date date1= (bookings.getScheduleFlight().getTakeoffDate());
	    	Date date= new Date();
	    	if(date1.before(date))
	    	{
	    		bookingFlightList.add(bookings);
	    	}
	    }
	   bookingListDto=bookingConverter.sendBookingHistory(bookingFlightList);
	  return bookingListDto;
    }
	
	public ArrayList<BookingHistoryDto> showCancelledBooking(int id)
	{
	    ArrayList<BookingHistoryDto> bookingListDto= new ArrayList<BookingHistoryDto>();
		 ArrayList<Bookings> bookingList2= new ArrayList<Bookings>();
			
		 List<Bookings> bookingList= null;
		 
		 Optional<User> u = userDao.findById(id);
		 User user =u.orElse(null);
	
		 bookingList=	bookingDao.findAll();

	   for(Bookings bookings: bookingList)
	    {
		 
		   if(user.getUserId() == bookings.getUser().getUserId())
	    	{

	    					if(bookings.getBookingStatus().equals("cancelled"))
	    					{
	    						bookingList2.add(bookings);
	    						
	    					}
	    	}
	    }
	   bookingListDto=bookingConverter.sendBookingHistory(bookingList2);
	  return bookingListDto;
}
	public Bookings updateBookingStatusOnCancelling(int id) 
	{
		Optional<Bookings> booking = bookingDao.findById(id);
		Bookings book= booking.orElse(null);
		book.setBookingStatus("cancelled");
		
		Bookings booking1= bookingDao.save(book);
	    return booking1;
	}
}
