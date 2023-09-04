package com.project.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "scheduleflight")
public class ScheduleFlight {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int scheduleId; //pk
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "flightId")
	private Flight flightschedule;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="routeId")
	private Route routeSchedule;
	
	@Temporal(TemporalType.DATE)
	private Date takeoffDate;
	@Temporal(TemporalType.DATE)
	private Date landingDate;

	@Temporal(TemporalType.TIME)
	private Date takeoffTime;
	@Temporal(TemporalType.TIME)
	private Date landingTime;
	
	@Column(name ="availableEconomyClassSeat")
	private int available_economyClass_seat ;
	
	@Column(name ="availableBusinessClassSeat")
	private int available_businessClass_seat ;
	
	@Column(name ="availableFirstClassSeat")
	private int available_firstClass_seat;
	
	@OneToMany(mappedBy ="scheduleFlight")
	private List<Bookings> bookingList;
	
	
	
	
	
	public ScheduleFlight() {
		super();
		
	}



	public ScheduleFlight(int scheduleId, Flight flightschedule, Route routeSchedule, Date takeoffDate, Date landingDate,
			Date takeoffTime, Date landingTime, int available_economyClass_seat, int available_businessClass_seat,
			int available_firstClass_seat, List<Bookings> bookingList) {
		super();
		this.scheduleId = scheduleId;
		this.flightschedule = flightschedule;
		this.routeSchedule = routeSchedule;
		this.takeoffDate = takeoffDate;
		this.landingDate = landingDate;
		this.takeoffTime = takeoffTime;
		this.landingTime = landingTime;
		this.available_economyClass_seat = available_economyClass_seat;
		this.available_businessClass_seat = available_businessClass_seat;
		this.available_firstClass_seat = available_firstClass_seat;
		this.bookingList = bookingList;
	}






	public ScheduleFlight(int scheduleId, Flight flightschedule, Route routeSchedule, Date takeoffDate, Date landingDate,
			Date takeoffTime, Date landingTime, int available_economyClass_seat, int available_businessClass_seat,
			int available_firstClass_seat) {
		super();
		this.scheduleId = scheduleId;
		this.flightschedule = flightschedule;
		this.routeSchedule = routeSchedule;
		this.takeoffDate = takeoffDate;
		this.landingDate = landingDate;
		this.takeoffTime = takeoffTime;
		this.landingTime = landingTime;
		this.available_economyClass_seat = available_economyClass_seat;
		this.available_businessClass_seat = available_businessClass_seat;
		this.available_firstClass_seat = available_firstClass_seat;
	}



	public int getScheduleId() {
		return scheduleId;
	}



	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}



	public Flight getFlightschedule() {
		return flightschedule;
	}



	public void setFlightschedule(Flight flightschedule) {
		this.flightschedule = flightschedule;
	}



	public Route getRouteSchedule() {
		return routeSchedule;
	}



	public void setRouteSchedule(Route routeSchedule) {
		this.routeSchedule = routeSchedule;
	}



	public Date getTakeoffDate() {
		return takeoffDate;
	}



	public void setTakeoffDate(Date takeoffDate) {
		this.takeoffDate = takeoffDate;
	}



	public Date getLandingDate() {
		return landingDate;
	}




	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}



	public Date getTakeoffTime() {
		return takeoffTime;
	}



	public void setTakeoffTime(Date takeoffTime) {
		this.takeoffTime = takeoffTime;
	}



	public Date getLandingTime() {
		return landingTime;
	}



	public void setLandingTime(Date landingTime) {
		this.landingTime = landingTime;
	}



	public int getAvailable_economyClass_seat() {
		return available_economyClass_seat;
	}



	public void setAvailable_economyClass_seat(int available_economyClass_seat) {
		this.available_economyClass_seat = available_economyClass_seat;
	}



	public int getAvailable_businessClass_seat() {
		return available_businessClass_seat;
	}



	public void setAvailable_businessClass_seat(int available_businessClass_seat) {
		this.available_businessClass_seat = available_businessClass_seat;
	}



	public int getAvailable_firstClass_seat() {
		return available_firstClass_seat;
	}



	public void setAvailable_firstClass_seat(int available_firstClass_seat) {
		this.available_firstClass_seat = available_firstClass_seat;
	}



	public List<Bookings> getBookingList() {
		return bookingList;
	}



	public void setBookingList(List<Bookings> bookingList) {
		this.bookingList = bookingList;
	}



	@Override
	public String toString() {
		return "ScheduleFlight [scheduleId=" + scheduleId + ", flightschedule=" + flightschedule + ", routeSchedule="
				+ routeSchedule + ", takeoffDate=" + takeoffDate + ", landingDate=" + landingDate + ", takeoffTime="
				+ takeoffTime + ", landingTime=" + landingTime + ", available_economyClass_seat="
				+ available_economyClass_seat + ", available_businessClass_seat=" + available_businessClass_seat
				+ ", available_firstClass_seat=" + available_firstClass_seat + ", bookingList=" + bookingList + "]";
	}




}
