package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.Passenger;
@Repository
public interface PassengerDao extends JpaRepository<Passenger, Integer> {


	//Passenger fideByPassengerAadharNo(int passengerAadharNo);

}
