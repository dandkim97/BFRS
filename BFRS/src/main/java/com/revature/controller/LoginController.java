package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Login;
import com.revature.services.LoginService;

@Controller
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
	
	@PostMapping
	public String login(String username, String password, HttpSession session) {
		Login l = ls.login(username, password);
		System.out.println(username+" "+password);
		if(l==null)
			return "redirect:login";
		session.setAttribute("login", l);
		return "redirect:home";
	}
}