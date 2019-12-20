package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Plane;
import com.revature.services.PlaneService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/plane")
public class PlaneController {
	
	@Autowired
	private PlaneService ps;
	
	@GetMapping(value="{model}")
	public ResponseEntity<Plane> getPlane(@PathVariable String model){
		Plane p = ps.getPlane(model);
		if(p == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(p);
	}

}
