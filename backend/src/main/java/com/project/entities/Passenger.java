package com.project.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.NotNull;



@Entity
@Table(name="passenger")
public class Passenger {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int passengerId;
	@NotNull
	private String passengerName;
	@Temporal(TemporalType.DATE)
	private Date passengerDob;
	private int passengerAadharNo;
	private int passengerpassportNo;
	@NotNull
	private String email;
	@NotNull
	private String phoneNo;
	
	@OneToMany(mappedBy ="passenger")
	//private Bookings bookings;
	List<Bookings> bookings;
	
	

	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Passenger(int passengerId, String passengerName, Date passengerDob, int passengerAadharNo,
			int passengerpassportNo, String email, String phoneNo, List<Bookings> bookings) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerDob = passengerDob;
		this.passengerAadharNo = passengerAadharNo;
		this.passengerpassportNo = passengerpassportNo;
		this.email = email;
		this.phoneNo = phoneNo;
		this.bookings = bookings;
	}




	public int getPassengerId() {
		return passengerId;
	}




	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}




	public String getPassengerName() {
		return passengerName;
	}




	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}




	public Date getPassengerDob() {
		return passengerDob;
	}




	public void setPassengerDob(Date passengerDob) {
		this.passengerDob = passengerDob;
	}




	public int getPassengerAadharNo() {
		return passengerAadharNo;
	}




	public void setPassengerAadharNo(int passengerAadharNo) {
		this.passengerAadharNo = passengerAadharNo;
	}




	public int getPassengerpassportNo() {
		return passengerpassportNo;
	}




	public void setPassengerpassportNo(int passengerpassportNo) {
		this.passengerpassportNo = passengerpassportNo;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhoneNo() {
		return phoneNo;
	}




	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}




	public List<Bookings> getBookings() {
		return bookings;
	}




	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}




	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerDob="
				+ passengerDob + ", passengerAadharNo=" + passengerAadharNo + ", passengerpassportNo="
				+ passengerpassportNo + ", email=" + email + ", phoneNo=" + phoneNo + ", bookings=" + bookings + "]";
	}





}
