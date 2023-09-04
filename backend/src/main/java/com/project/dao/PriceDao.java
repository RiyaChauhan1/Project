package com.project.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.entities.Price;
import com.project.entities.Route;

@Repository
public interface PriceDao extends JpaRepository<Price, Integer> 
{
//	@Query("SELECT r FROM Route r WHERE r.routeId = :routeId ")
//	List<Price> findByRoute(@Param("routeId") Route routeId);
	
	//@Query("SELECT r FROM Route r,Flight f WHERE r.f.flightId = :routeId ")
	//Optional<Price> findByFlight(@Param("flightId") int flightId);
//
//	//List<Price> findByRoute(int i);
//	
////	@Query("SELECT r FROM Route r WHERE r.routeId = :i ")
////	List<Price> findByRoute(@Param("routeId") int i);
//	
//	@Query("SELECT p FROM Price p WHERE p.routeId = ?1")
//	Optional<Price> findByRouteId(int routeId);
	
}
