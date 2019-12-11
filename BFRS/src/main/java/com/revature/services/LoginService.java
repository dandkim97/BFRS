package com.revature.services;

import java.util.Set;

import com.revature.beans.Login;

public interface LoginService {
	public Login getLogin(String username, String pswrd);
	public Login getLoginById(Integer i);
	public Set<Login> getLogins();
	public void deleteLogin(Login l);
	public void updateLogin(Login l);
	public void addLogin(Login l);
}
