package com.project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.project.entities.Passenger;
import com.project.entities.User;
@Component
public class DtoEntityConverter
{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	public User convertToUserEntity(UserDto udto)
	{
		User user=new User();
		System.out.println("in user converter "+udto);
		user.setFirstName(udto.getFirstName());
		System.out.println("in firstname "+udto.getFirstName());
		System.out.println("in firstname "+user.getFirstName());
		user.setLastName(udto.getLastName());
		user.setEmail(udto.getEmail());
		user.setPassword(udto.getPassword());
		user.setRole("user");
		System.out.println("in user converter "+user);
		return user;
	}
	public UserDto convertToUserDto(User u)
	{
		UserDto user=new UserDto();
		user.setId(u.getUserId());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		user.setRole(u.getRole());
		return user;
	}
	
	public Passenger convertToPassengerEntity(PassengerInputDto pssIn)
	{
		Passenger p=new Passenger();
		p.setPassengerName(pssIn.getName());
		p.setEmail(pssIn.getEmail());
		p.setPassengerAadharNo(pssIn.getAdharCardNo());
		try {
			p.setPassengerDob(sdf.parse(pssIn.getDob()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		p.setPhoneNo(pssIn.getPhoneNo());
		p.setPassengerpassportNo(pssIn.getPassPortNo());
	    
		return p;
	}
	
	public PassengerOutDto convertToPassengerDto(Passenger p)
	{
		PassengerOutDto  passdto=new PassengerOutDto();
		passdto.setId(p.getPassengerId());
		passdto.setAdharCardNo(p.getPassengerAadharNo());
		passdto.setDob(sdf.format(p.getPassengerDob()));
		passdto.setEmail(p.getEmail());
		passdto.setName(p.getPassengerName());
		passdto.setPassPortNo(p.getPassengerpassportNo());
		passdto.setPhoneNo(p.getPhoneNo());
		return passdto;
	
}

}
