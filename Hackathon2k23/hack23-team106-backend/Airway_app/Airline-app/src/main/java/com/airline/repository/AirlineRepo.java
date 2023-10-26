package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.airline.model.Airline;

public interface AirlineRepo extends JpaRepository<Airline,Integer> {

}
