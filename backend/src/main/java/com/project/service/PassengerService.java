package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.PassengerDao;
import com.project.dto.DtoEntityConverter;
import com.project.dto.PassengerDeleteDto;
import com.project.dto.PassengerInputDto;
import com.project.dto.PassengerOutDto;
import com.project.entities.Passenger;

@Transactional
@Service
public class PassengerService 
{
	
	@Autowired
	private PassengerDao passengerdao;
	
	@Autowired
	DtoEntityConverter converter;
	
	public Passenger addPassenger(PassengerInputDto p) 
	{
		Passenger p1=converter.convertToPassengerEntity(p);
		System.out.println(p1);
		Passenger p2=passengerdao.save(p1);
		//Passenger p3=passengerdao.fideByPassengerAadharNo(p2.getPassengerAadharNo());
		System.out.println(p2);
		//PassengerOutDto p4=converter.convertToPassengerDto(p2);
		
		return p2;
	}

	public int deleteById(int id) 
	{
		//int pid=id.getId();
		passengerdao.deleteById(id);
		return 1;
	}

	public Passenger findById(int id) 
	{
		Optional<Passenger> p1=passengerdao.findById(id);
		Passenger p2 =p1.orElse(null);
		return p2;
	}

	public Passenger savePassenger(Passenger p) {
		// TODO Auto-generated method stub
		return null;
	}

}
