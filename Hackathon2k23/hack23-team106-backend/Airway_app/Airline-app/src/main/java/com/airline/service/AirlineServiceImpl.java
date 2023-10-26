package com.airline.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.model.Airline;
import com.airline.repository.AirlineRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AirlineServiceImpl implements AirlineService {

	@Autowired
	AirlineRepo airlineRepo;

	@Override
	public List<Airline> getAirlines() {

		List<Airline> dataList = new ArrayList<>();

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			// Specify the path to your json file
			File jsonFile = new File("C:\\Airway_app\\airlines.json");

			// read json data into a list of JavaObject
			dataList = objectMapper.readValue(jsonFile, new TypeReference<List<Airline>>() {
			});

			// ORM(hibernate:type of ORM) saving java object to the database
			for (Airline obj : dataList) {
				airlineRepo.save(obj);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;

	}

}
