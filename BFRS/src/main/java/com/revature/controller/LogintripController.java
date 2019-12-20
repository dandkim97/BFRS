package com.revature.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Logintrip;
import com.revature.beans.TripView;
import com.revature.data.LogintripDao;
import com.revature.data.TripDao;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/logintrips")
public class LogintripController {
	
	@Autowired
	private LogintripDao ld;
	
	@Autowired
	private TripDao td;
	
	@GetMapping 
	public ResponseEntity<List<TripView>> getAllHistoryTrips() {
			return ResponseEntity.ok(td.getAllHistoryTrips());
	}
	
//	@GetMapping 
//	public ResponseEntity<Set<Logintrip>> getLogintrips() {
//			return ResponseEntity.ok(ld.getLogintrips());
//	}
	 
	@PostMapping
	public ResponseEntity<Logintrip> addLogintrip(@RequestBody Logintrip lt) {
		System.out.println(lt);
		ld.addLogintrip(lt);
		return ResponseEntity.status(201).body(lt);
	}
}
