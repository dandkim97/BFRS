package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Trip;
import com.revature.services.PlaneService;
import com.revature.services.TripService;
import com.revature.services.hibernate.PlaneServiceHibernate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/trips")

public class TripController {

	@Autowired
	private TripService ts;
	
	@GetMapping
	public ResponseEntity<List<Trip>> findAllAvailTrips() {
		PlaneService ps = new PlaneServiceHibernate();
		System.out.println(ps.findAllAvailTrips());
		return ResponseEntity.ok(ps.findAllAvailTrips());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Trip> getForm(@PathVariable Integer id) {
		Trip t = ts.getTripById(id);
		if (t == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(t);
	}
	
	@PostMapping
	public ResponseEntity<Trip> addTrip(@RequestBody Trip t) {
		ts.addTrip(t);
		return ResponseEntity.status(201).body(t);
	}
	
	@PutMapping
	public ResponseEntity<Trip> updateTrip(@RequestBody Trip t){
		System.out.println("\n\n\n" + t +  "\n\n\n");
		return ResponseEntity.ok(ts.updateTrip(t));
	}

}
