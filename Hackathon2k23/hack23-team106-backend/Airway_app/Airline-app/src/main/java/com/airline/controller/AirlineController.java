package com.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.model.Airline;
import com.airline.service.AirlineService;

@RestController
@RequestMapping("/api/airline")

public class AirlineController {

	@Autowired
	AirlineService airlineService;

	@GetMapping("/injest")
	public List<Airline> injestAllAirline() {
		return airlineService.getAirlines();
	}

}
