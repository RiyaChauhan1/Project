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
public interface RouteDao extends JpaRepository<Route, Integer> 
{
	//@Query("SELECT r.routeId,r.source,r.destination FROM Route r WHERE r.source = :source AND r.destination = :destination")
//	List<Route> findFlight(@Param("source") String source,@Param("destination")String destination);
	
//	@Query("SELECT r.routeId,r.source,r.destination FROM Route r WHERE r.source = :source AND r.destination = :destination")
	//List<Route> findFlight(@Param("source") String source,@Param("destination")String destination);
	//@Query("SELECT r FROM Route r WHERE r.routeId = :routeId ")
	//Optional<Price> findByRouteId(@Param("routeId") int flightId);
//
}
