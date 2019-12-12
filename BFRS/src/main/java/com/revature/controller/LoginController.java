package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Login;
import com.revature.services.LoginService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/login")
public class LoginController {
	@Autowired
	private LoginService ls;
	
	@RequestMapping(method=RequestMethod.GET)
	public String goLogin(HttpSession session) {
		if(session.getAttribute("login") == null)
			return "static/login.html";
		else
			return "static/home.html";
	}
	
	@GetMapping
	public ResponseEntity<Login> login(@PathVariable Login l) {
		Login login = ls.login(l.getUsername(), l.getPswrd());
		return ResponseEntity.ok(login);
	}
	
//	@PostMapping
//	public String login(String username, String password, HttpSession session) {
//		Login l = ls.login(username, password);
//		System.out.println(username+" "+password);
//		if(l==null)
//			return "redirect:login";
//		session.setAttribute("login", l);
//		return "redirect:home";
//	}
}