package com.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Airport;
import com.airline.service.AirportService;

@RestController
@RequestMapping("/api/airport")
public class AirportController {
	
	@Autowired AirportService airportService;
	
	@GetMapping("/injest")
	public List<Airport> getAllAirport(){
		return airportService.getAirports();
	}
	

}
