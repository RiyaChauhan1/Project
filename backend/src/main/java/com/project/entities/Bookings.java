package com.project.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bookings")
public class Bookings {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int bookingNo;
	private String paymentStatus;
	private String bookingStatus;
	private int seatNo;
	private double totalAmount;

	@ManyToOne
	@JoinColumn(name="scheduleId")
    private ScheduleFlight scheduleFlight; //fk
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="passengerId")
	private Passenger passenger;
	
	
	public Bookings() {
		super();
		
	}


	public Bookings(int bookingNo, ScheduleFlight scheduleFlight, User user, String paymentStatus, String bookingStatus,
			int seatNo, double totalAmount) {
		super();
		this.bookingNo = bookingNo;
		this.scheduleFlight = scheduleFlight;
		this.user = user;
		this.paymentStatus = paymentStatus;
		this.bookingStatus = bookingStatus;
		this.seatNo = seatNo;
		this.totalAmount = totalAmount;
	}


	public Bookings(int bookingNo, ScheduleFlight scheduleFlight, User user, String paymentStatus, String bookingStatus,
			int seatNo, double totalAmount, Passenger passenger) {
		super();
		this.bookingNo = bookingNo;
		this.scheduleFlight = scheduleFlight;
		this.user = user;
		this.paymentStatus = paymentStatus;
		this.bookingStatus = bookingStatus;
		this.seatNo = seatNo;
		this.totalAmount = totalAmount;
		this.passenger = passenger;
	}


	public int getBookingNo() {
		return bookingNo;
	}


	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}


	public ScheduleFlight getScheduleFlight() {
		return scheduleFlight;
	}


	public void setScheduleFlight(ScheduleFlight scheduleFlight) {
		this.scheduleFlight = scheduleFlight;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public int getSeatNo() {
		return seatNo;
	}


	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	public Passenger getPassenger() {
		return passenger;
	}


	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}


	@Override
	public String toString() {
		return "Bookings [bookingNo=" + bookingNo + ", scheduleFlight=" + scheduleFlight + ", user=" + user
				+ ", paymentStatus=" + paymentStatus + ", bookingStatus=" + bookingStatus + ", seatNo=" + seatNo
				+ ", totalAmount=" + totalAmount + ", passenger=" + passenger + "]";
	}


	
	
		
	

}
