package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Login;
import com.revature.services.LoginService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@PostMapping
	public ResponseEntity<Login> addLogin(@RequestBody Login l){
		ls.addLogin(l);
		// commment
		return ResponseEntity.status(201).body(l);
	}
	
}
