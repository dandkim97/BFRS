package com.revature.controllers;

import java.util.Set;

//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.beans.Trip;

import com.revature.services.TripService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/trips")
 
//
public class TripController {

	@Autowired
	private TripService ts;
	
	@GetMapping 
	public ResponseEntity<Set<Trip>> getTrips() {
			return ResponseEntity.ok(ts.getTrips());
		}
	

	
	
	

}
