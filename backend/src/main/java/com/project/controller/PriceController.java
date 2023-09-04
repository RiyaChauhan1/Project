package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.GetPrice;
import com.project.dto.GetScheduleDetails;
import com.project.dto.PriceDetails;
import com.project.dto.PriceModify;
import com.project.dto.Response;
import com.project.entities.Flight;
import com.project.entities.Price;
import com.project.entities.ScheduleFlight;
import com.project.service.FlightService;
import com.project.service.PriceService;
import com.project.service.RouteService;

@CrossOrigin(origins = "*")
@RestController
public class PriceController {
	@Autowired
	private PriceService pService;
	@Autowired
	FlightService fService;
	@Autowired
	RouteService rService;
	
	
	@PostMapping("price/add")
	public ResponseEntity<?> addPrice(@RequestBody GetPrice p)
	{
		System.out.println("the dto get :"+p);
		Price price=new Price();
		{
			System.out.println("the dto get :"+price);
			price.setFlight(fService.findById(p.getFlightId()));
			price.setRoute(rService.findById(p.getRouteId()));
			price.setBusinessClassPrice(p.getBusinessClassPrice());
			price.setEconomyClassPrice(p.getEconomyClassPrice());
			price.setFirstClassPrice(p.getFirstClassPrice());
			
		}
		Price result=pService.addPrice(price);
		if(result==null)
		{
			return Response.error("fail to add price");
		}
		return Response.success("route added");
	}
	
	@GetMapping("price/getAll")
	public ResponseEntity<?> getPriceList()
	{
	
		List<PriceDetails> priceList=pService.getPriceList();
		
			
		
		
		if(priceList==null)
		{
			return Response.error("fail to get price");
		}
		return Response.success(priceList);
	}
	@GetMapping("price/get/{id}")
	public ResponseEntity<?> getPrice(@PathVariable int id)
	{
	
		PriceDetails price=pService.getPrice(id);
			
		if(price==null)
		{
			return Response.error("fail to get price");
		}
		return Response.success(price);
	}
	//edit schedule
		@PutMapping("price/edit/{id}")
		public ResponseEntity<?> modifyPrice(@PathVariable("id") int id,@RequestBody PriceModify pm)
		{
			System.out.println("111");
			Price result=pService.editPrice(pm,id);
			if(result==null)
			{
				return Response.error("fail to modify schedule");
			}
			return Response.success("modified sucessflly");
		}
	


}
