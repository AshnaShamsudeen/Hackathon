package com.airline.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.model.Airport;
import com.airline.repository.AirportRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepo airportRepo;

	@Override
	public List<Airport> getAirports() {
		// TODO Auto-generated method stub

		List<Airport> airportData = new ArrayList<>();

		ObjectMapper objectMapper1 = new ObjectMapper();
		try {

			File jsonFile1 = new File("C:\\Airway_app\\airports.json");
			airportData = objectMapper1.readValue(jsonFile1, new TypeReference<List<Airport>>() {
			});

			for (Airport obj1 : airportData) {
				airportRepo.save(obj1);
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return airportData;
	}

}
