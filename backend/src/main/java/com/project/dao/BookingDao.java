package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.entities.Bookings;

public interface BookingDao extends JpaRepository<Bookings, Integer> {

}
