package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PriceDao;
import com.project.dto.PriceDetails;
import com.project.dto.PriceModify;
import com.project.entities.Price;

@Transactional
@Service
public class PriceService {
	@Autowired
	PriceDao pDao;
	
	public Price addPrice(Price p)
	{
		return pDao.save(p);
	}
	public List<PriceDetails> getPriceList()
	{
		List<Price> allPrice =pDao.findAll();
		List<PriceDetails> list=new ArrayList<>();
		for(Price p:allPrice)
		{
			PriceDetails temp=new PriceDetails();
			{
				temp.setPriceId(p.getPriceId());
				temp.setAirlineName(p.getFlight().getAirlineName());
				temp.setSource(p.getRoute().getSource());
				temp.setDestination(p.getRoute().getDestination());
				temp.setFirstClassPrice(p.getFirstClassPrice());
				temp.setEconomyClassPrice(p.getEconomyClassPrice());
				temp.setBusinessClassPrice(p.getBusinessClassPrice());
				list.add(temp);
			}
		}
		return list;
		
	}
	
	public PriceDetails getPrice(int id) 
	{
		Optional<Price> p1=pDao.findById(id);
		Price p =p1.orElse(null);
		
		PriceDetails temp=new PriceDetails();
		{
		
			temp.setAirlineName(p.getFlight().getAirlineName());
			temp.setSource(p.getRoute().getSource());
			temp.setDestination(p.getRoute().getDestination());
			temp.setFirstClassPrice(p.getFirstClassPrice());
			temp.setEconomyClassPrice(p.getEconomyClassPrice());
			temp.setBusinessClassPrice(p.getBusinessClassPrice());	
		}
		
		return temp;
	}
	public Price editPrice(PriceModify pm, int id) {
		Optional<Price> p1=pDao.findById(id);
		Price p =p1.orElse(null);
		p.setBusinessClassPrice(pm.getBusinessClassPrice());
		p.setEconomyClassPrice(pm.getEconomyClassPrice());
		p.setFirstClassPrice(pm.getFirstClassPrice());
		pDao.save(p);
		return p;
	}
	

}
