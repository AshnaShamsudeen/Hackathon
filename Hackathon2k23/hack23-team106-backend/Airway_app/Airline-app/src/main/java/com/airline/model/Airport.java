package com.airline.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airport {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
	    @JsonProperty("code")
	    private String iataCode;
	    @JsonProperty("lat")
	    private double latitude;
	    @JsonProperty("lon")
	    private double longitude;
	    @JsonProperty("name")
	    private String airportName;
	    private String city;
	    private String state;
	    private String country;
	    @JsonProperty("icao")
	    private String icaoCode;
	    @JsonProperty("direct_flights")
	    private int directFlights;
	    @Column(name="created_on",columnDefinition = "TIMESTAMP")
	    private LocalDateTime createdOn;
	    @Column(name="updated_on",columnDefinition = "TIMESTAMP")
	    private LocalDateTime updatedOn;
	    
	    
	    @PrePersist
	    protected void onCreate() {
	    	        createdOn = LocalDateTime.now();
	    	    }
	    @PreUpdate
	    protected void onUpdate() {
	    	updatedOn=LocalDateTime.now();
	    }
	    

}
