package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PassengerDao;
import com.project.dao.UserDao;
import com.project.dto.DtoEntityConverter;
import com.project.dto.PassengerInputDto;
import com.project.dto.PassengerOutDto;
import com.project.dto.SearchFlight;
import com.project.dto.UserDto;
import com.project.entities.Passenger;
import com.project.entities.User;


@Transactional
@Service
public class UserService 
{
	@Autowired
	private UserDao dao;
	
	@Autowired
	DtoEntityConverter converter;
	
	public UserDto loginVerification(String Email,String password)
	{
		User user=dao.findByEmail(Email);
		if(user!=null)
		{
			if(password.equalsIgnoreCase(user.getPassword()))
			{
				UserDto result = converter.convertToUserDto(user);
				result.setPassword("********");
				return result;
			
			}
		}
		return null;
	}
//	public User getUser(int id)
//	{
//		//return dao.findById(id);
//	}
	public List<User> findAllUser()
	{

     return dao.findAll();
	}
	public UserDto addUser(UserDto user)
	{
		System.out.println("user dto ="+user);
		User u=converter.convertToUserEntity(user);
		System.out.println("user  ="+u);
		User us=dao.save(u);
		user=converter.convertToUserDto(us);
		
		return user;
	}
	
	

}
