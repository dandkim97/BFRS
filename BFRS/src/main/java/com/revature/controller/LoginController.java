package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Login;
import com.revature.services.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login")
public class LoginController {

	@Autowired
	private LoginService ls;
	
	@PostMapping
	public ResponseEntity<Login> login(@RequestBody Login l, HttpSession session) {
		Login login = ls.getLogin(l.getUsername(), l.getPswrd());
		System.out.println(login);
		if (login == null) {
			return ResponseEntity.status(401).build();
		}
		session.setAttribute("loggedUser", login);
		return ResponseEntity.ok(login);
	}

	@DeleteMapping
	public ResponseEntity<Void> logout(HttpSession session) {
		System.out.println("Logging out " + session.getAttribute("loggedUser"));
		session.invalidate();
		return ResponseEntity.noContent().build();
	}

	@PostMapping(value="/add")
	public ResponseEntity<Login> addLogin(@RequestBody Login l) {
		ls.addLogin(l);
		return ResponseEntity.status(201).body(l);
	}

}
