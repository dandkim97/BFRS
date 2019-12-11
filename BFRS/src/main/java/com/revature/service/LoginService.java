package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Login;
import com.revature.data.LoginDAO;

@Service
public class LoginService {
	@Autowired
	private LoginDAO ld;
	public Login login(String username, String password) {
		return ld.getLogin(username, password);
	}
}
