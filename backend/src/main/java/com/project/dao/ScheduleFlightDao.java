package com.project.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.project.dto.SerchFlightDto;
import com.project.entities.ScheduleFlight;
@Repository
public interface ScheduleFlightDao extends JpaRepository<ScheduleFlight, Integer> 
{

	@Query("SELECT sh FROM ScheduleFlight sh WHERE sh.takeoffDate = :date ")
	List<ScheduleFlight> findByTakeoffDate(@Param("date") Date date);
	//onathor same query
//	@Query("SELECT sh FROM ScheduleFlight sh WHERE sh.takeoffDate = ?1 ")
//	List<ScheduleFlight> findByTakeoffDate(Date date);
	
//	@Query("SELECT sh FROM ScheduleFlight sh WHERE sh.takeoffDate = :date ")
//	List<ScheduleFlight> findByTakeoffDate(@Param("date") Date date,@Param("source") String source,@Param("destination") String destination);
//	
//	@Query("select a from Article a where a.creationDateTime <= :creationDateTime")
//    List<Article> findAllWithCreationDateTimeBefore(
//      @Param("creationDateTime") Date creationDateTime);
}
