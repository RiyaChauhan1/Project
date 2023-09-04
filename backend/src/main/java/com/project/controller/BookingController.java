package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.BookingHistoryDto;
import com.project.dto.Response;
import com.project.entities.Bookings;
import com.project.service.BookingService;

@CrossOrigin(origins ="*")
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/bookings/upcoming/{id}")
	public ResponseEntity<?> UpcomingBookings(@PathVariable int id)
	{
		ArrayList<BookingHistoryDto> bookingDto=bookingService.showUpcomingBooking(id);
		if(bookingDto==null)
		{
			return Response.error("No Upcoming Bookings");
		}
		return Response.success(bookingDto);
	}
	
	@PostMapping("/bookings/completed/{id}")
	public ResponseEntity<?> completedBookings(@PathVariable int id)
	{
		ArrayList<BookingHistoryDto> bookingDto=bookingService.showCompletedBooking(id);
		if(bookingDto==null)
		{
			return Response.error("No Completed Bookings");
		}
		return Response.success(bookingDto);
	}
	@PostMapping("/bookings/cancelled/{id}")
	public ResponseEntity<?> showCancelledBookings(@PathVariable int id)
	{
		ArrayList<BookingHistoryDto> bookingDto=bookingService.showCancelledBooking(id);
		if(bookingDto==null)
		{
			return Response.error("No Cancelled Bookings");
		}
		return Response.success(bookingDto);
	}
	
	@PutMapping("/bookings/cancel/{id}")
	public ResponseEntity<?> cancelBookings(@PathVariable int id)
	{
		Bookings b= bookingService.updateBookingStatusOnCancelling(id);
		if(b==null)
		{
			return Response.error("No Upcoming Bookings");
		}
		return Response.success("Cancelled");
	}
	

}
