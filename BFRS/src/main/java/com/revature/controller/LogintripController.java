package com.revature.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.TripView;
import com.revature.data.TripDao;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/logintrips")
public class LogintripController {
	
	@Autowired
	private TripDao td;
	
	
	@GetMapping 
	public ResponseEntity<List<TripView>> getAllHistoryTrips() {
			return ResponseEntity.ok(td.getAllHistoryTrips());
		}
	 
}
