package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Logintrip;
import com.revature.data.LogintripDao;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/logintrips")
public class LogintripController {
	
	@Autowired
	private LogintripDao ld;
	
	
	@GetMapping 
	public ResponseEntity<Set<Logintrip>> getLogintrips() {
			return ResponseEntity.ok(ld.getLogintrips());
		}
	 

}
