package com.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Credential;
import com.project.dto.CustomException;
import com.project.dto.GetAllRoute;
import com.project.dto.GetRoute;
import com.project.dto.Response;
import com.project.entities.Route;
import com.project.entities.User;
import com.project.service.RouteService;

@CrossOrigin(origins = "*")
@RestController
public class RouteController
{
	@Autowired
	private RouteService service;
	
	
	@PostMapping("/route/add")
	public ResponseEntity<?> addRoute(@RequestBody Route r )
	{
		Route result=service.addRoute(r);
		if(result==null)
		{
			return Response.error("route  not found");
		}
		return Response.success(result);
	}
	
	@GetMapping("/route/getAll")
	public ResponseEntity<?> getAllRoute()
	{
		List<GetRoute> result=service.getAllRoute();
		if(result==null)
		{
			return Response.error("user not found");
		}
		return Response.success(result);
	}
	
	@DeleteMapping("/route/delete/{id}")
	public ResponseEntity<?> deleteRoute(@PathVariable int id)
	{
		System.out.println(" :"+id);
		
		int result=service.deleteById(id);
		if(result!=1)
		{
			return Response.error("route not found");
		}
		return Response.success(result);
	}
	
	@PutMapping("route/edit/{id}")
	public ResponseEntity<?> modifyFlight(@PathVariable("id") int id,@RequestBody GetRoute r)
	{
		System.out.println("the route of id :"+id);
		Route route=service.findById(id);
	
		route.setSource(r.getSource());
		route.setDestination(r.getDestination());

		Route result=service.modifyRoute(route);
		if(result==null)
		{
			return Response.error(" fail to edit route");
		}
		return Response.success(result);
	}
	
	
}
