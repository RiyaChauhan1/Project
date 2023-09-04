package com.project.dto;

 public class TicketDTO {
 private int passengerId;
 private int scheduleId;
 private int userId; 
 private String seatType;
 public TicketDTO() {
	super();
	// TODO Auto-generated constructor stub
 }
public TicketDTO(int passengerId, int scheduleId, int userId, String seatType) {
	super();
	this.passengerId = passengerId;
	this.scheduleId = scheduleId;
	this.userId = userId;
	this.seatType = seatType;
}
public int getPassengerId() {
	return passengerId;
}
public void setPassengerId(int passengerId) {
	this.passengerId = passengerId;
}
public int getScheduleId() {
	return scheduleId;
}
public void setScheduleId(int scheduleId) {
	this.scheduleId = scheduleId;
}
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public String getSeatType() {
	return seatType;
}
public void setSeatType(String seatType) {
	this.seatType = seatType;
}
@Override
public String toString() {
	return "TicketDTO [passengerId=" + passengerId + ", scheduleId=" + scheduleId + ", userId=" + userId + ", seatType="
			+ seatType + "]";
}
 
 
}
