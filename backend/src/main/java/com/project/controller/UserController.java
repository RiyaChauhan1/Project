package com.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Credential;
import com.project.dto.PassengerDeleteDto;
import com.project.dto.PassengerInputDto;
import com.project.dto.PassengerOutDto;
import com.project.dto.Response;
import com.project.dto.SearchFlight;
import com.project.dto.UserDto;
import com.project.entities.User;
import com.project.service.PassengerService;
import com.project.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController 
{
	@Autowired
	private UserService userService;
	@Autowired
	private PassengerService passengerService;
	
	@PostMapping("/user/signin")
	public ResponseEntity<?> signin(@RequestBody Credential cred )
	{
		UserDto userDto=userService.loginVerification(cred.getEmail(), cred.getPassword());
		if(userDto==null)
		{
			return Response.error("user not found");
		}
		return Response.success(userDto);
	}
	@GetMapping("/users")
	public @ResponseBody List<User> findAll()
	{
		List<User> u=userService.findAllUser();
		return u;
	}
	@PostMapping("/user/signup")
	public ResponseEntity<?> signup(@RequestBody UserDto u)
	{
		System.out.println("in user signup user :"+u);
		UserDto result=userService.addUser(u);
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
	
	
	
	
    
}
