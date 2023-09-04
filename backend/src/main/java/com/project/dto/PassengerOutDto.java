package com.project.dto;

public class PassengerOutDto 
{
	private int id;
	private String name;
    private String email;
    private String dob;
    private String phoneNo;
    private int adharCardNo;
    private int passPortNo;
    
	public PassengerOutDto() {
		super();
	}
	public PassengerOutDto(int id, String name, String email, String dob, String phoneNo, int adharCardNo,
			int passPortNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.phoneNo = phoneNo;
		this.adharCardNo = adharCardNo;
		this.passPortNo = passPortNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getAdharCardNo() {
		return adharCardNo;
	}
	public void setAdharCardNo(int adharCardNo) {
		this.adharCardNo = adharCardNo;
	}
	public int getPassPortNo() {
		return passPortNo;
	}
	public void setPassPortNo(int passPortNo) {
		this.passPortNo = passPortNo;
	}
	@Override
	public String toString() {
		return "PassengerOutDto [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phoneNo="
				+ phoneNo + ", adharCardNo=" + adharCardNo + ", passPortNo=" + passPortNo + "]";
	}
	
	
}
