package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PriceDao;
import com.project.dao.RouteDao;
import com.project.dao.ScheduleFlightDao;
import com.project.dto.GetAllRoute;
import com.project.dto.GetRoute;
import com.project.entities.Route;



@Transactional
@Service
public class RouteService 
{
	@Autowired
	RouteDao rDao;
	@Autowired
	PriceDao pdao;
	@Autowired
	ScheduleFlightDao sdao;
	public Route addRoute(Route R)
	{
		rDao.save(R);
		return R;
	}
	public Route getRoute(String source,String Destination)
	{
		return null;
	}
	public Route findById(int routeId) {
		Optional<Route> r =rDao.findById(routeId);
		Route route=r.orElse(null);
		return route;
	}
	
	public ArrayList<GetAllRoute> findAllRoute() {
		List<Route> r=rDao.findAll();
		ArrayList<GetAllRoute> allRoute =new ArrayList<GetAllRoute>();
		for(Route r1 : r)
		{
			GetAllRoute r2 =new GetAllRoute();
			r2.setId(r1.getRouteId());
			r2.setSource(r1.getSource());
			r2.setDestination(r1.getDestination());
			try {
				allRoute.add(r2);
			} catch (Exception e) {
			}
			
		}
		
		return allRoute;
	}
	public List<GetRoute> getAllRoute()
	{
		List<Route> routelist= rDao.findAll();
		List<GetRoute> list=new ArrayList<>();
		for(Route r : routelist)
		{
			GetRoute temp=new GetRoute();
			{
				temp.setRouteId(r.getRouteId());
				temp.setSource(r.getSource());
				temp.setDestination(r.getDestination());
			}
			list.add(temp);
		}
		return list;
	}
	public int deleteById(int id) 
	{
		Route r=rDao.getById(id);
		sdao.deleteAllInBatch(r.getScheduleFlight());
		pdao.deleteAllInBatch(r.getPriceList());
		rDao.deleteById(id);
		return 1;
	}
	
	public Route modifyRoute(Route r) 
	{
		
		Route route =rDao.save(r);
		
		return route;
		
	}

	

}
