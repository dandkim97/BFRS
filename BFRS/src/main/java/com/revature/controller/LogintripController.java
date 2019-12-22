package com.revature.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Logintrip;
import com.revature.beans.TripView;
import com.revature.data.LogintripDao;
import com.revature.data.TripDao;
import com.revature.services.LogintripService;
import com.revature.data.FormDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/logintrips")
public class LogintripController {
	
	@Autowired
	private LogintripService ls;
	
	@Autowired
	private LogintripDao ld;
  
	@Autowired
	private TripDao td;
	
	@Autowired
	private FormDao fd;
	
	@GetMapping 
	public ResponseEntity<List<TripView>> getAllHistoryTrips() {
			return ResponseEntity.ok(td.getAllHistoryTrips());
	}
	 
	@PostMapping
	public ResponseEntity<Logintrip> addLogintrip(@RequestBody Logintrip lt) {
		System.out.println(lt);
		ls.addLogintrip(lt);
		Integer seatsToSubtract = fd.getForm(lt.getTrip().getId(), lt.getLogin().getId()).getNumSeats(); 
		td.addTripSeats(lt.getTrip(), -1*seatsToSubtract);
		return ResponseEntity.status(201).body(lt);
	}
	
	@DeleteMapping(value="{tId}/{uId}")
	public ResponseEntity<Void> deleteLoginTrip(@PathVariable("tId") Integer tId, @PathVariable("uId") Integer uId) {
		System.out.println("==============" + ld.getLoginTrip(tId, uId));
		ld.deleteLoginTrip(ld.getLoginTrip(tId, uId));
		Integer seatsToAdd = fd.getForm(tId, uId).getNumSeats(); 
		System.out.println("==============" + fd.getForm(tId, uId));
		System.out.println("==============" + seatsToAdd);
		td.addTripSeats(td.getTrip(tId), seatsToAdd); 
		return ResponseEntity.noContent().build();
	}
}
