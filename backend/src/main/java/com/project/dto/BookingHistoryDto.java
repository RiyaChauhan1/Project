package com.project.dto;



public class BookingHistoryDto {
    private int bookingNo;
	private String passengerName;
	private int seatNo;
	private String source;
	private String destination;
	private String CompanyName;
	private String AirlineName;
	private String takeoffDate;
	private String takeoffTime;
	private String landingDate;
	private String landingTime;
	private double totalPrice;
	private String bookingStatus;
	
	public BookingHistoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingHistoryDto(String passengerName, int seatNo, String source, String destination, String companyName,
			String airlineName, String takeoffDate, String takeoffTime, String landingDate, String landingTime,
			double totalPrice) {
		super();
		this.passengerName = passengerName;
		this.seatNo = seatNo;
		this.source = source;
		this.destination = destination;
		CompanyName = companyName;
		AirlineName = airlineName;
		this.takeoffDate = takeoffDate;
		this.takeoffTime = takeoffTime;
		this.landingDate = landingDate;
		this.landingTime = landingTime;
		this.totalPrice = totalPrice;
	}
	
	

	

	public BookingHistoryDto(int bookingNo, String passengerName, int seatNo, String source, String destination,
			String companyName, String airlineName, String takeoffDate, String takeoffTime, String landingDate,
			String landingTime, double totalPrice, String bookingStatus) {
		super();
		this.bookingNo = bookingNo;
		this.passengerName = passengerName;
		this.seatNo = seatNo;
		this.source = source;
		this.destination = destination;
		CompanyName = companyName;
		AirlineName = airlineName;
		this.takeoffDate = takeoffDate;
		this.takeoffTime = takeoffTime;
		this.landingDate = landingDate;
		this.landingTime = landingTime;
		this.totalPrice = totalPrice;
		this.bookingStatus = bookingStatus;
	}

	
	
	public int getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(int bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getAirlineName() {
		return AirlineName;
	}

	public void setAirlineName(String airlineName) {
		AirlineName = airlineName;
	}

	public String getTakeoffDate() {
		return takeoffDate;
	}

	public void setTakeoffDate(String takeoffDate) {
		this.takeoffDate = takeoffDate;
	}

	public String getTakeoffTime() {
		return takeoffTime;
	}

	public void setTakeoffTime(String takeoffTime) {
		this.takeoffTime = takeoffTime;
	}

	public String getLandingDate() {
		return landingDate;
	}

	public void setLandingDate(String landingDate) {
		this.landingDate = landingDate;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	@Override
	public String toString() {
		return "BookingHistoryDto [bookingNo=" + bookingNo + ", passengerName=" + passengerName + ", seatNo=" + seatNo
				+ ", source=" + source + ", destination=" + destination + ", CompanyName=" + CompanyName
				+ ", AirlineName=" + AirlineName + ", takeoffDate=" + takeoffDate + ", takeoffTime=" + takeoffTime
				+ ", landingDate=" + landingDate + ", landingTime=" + landingTime + ", totalPrice=" + totalPrice
				+ ", bookingStatus=" + bookingStatus + "]";
	}

	
	
	
	
}
