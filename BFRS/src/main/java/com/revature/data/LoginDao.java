package com.revature.data;

import com.revature.beans.Login;

public interface LoginDao {
	public Integer addLogin(Login l);
	public Login getLogin(String username, String pswrd);
	public Login getLogin(Login l);
	public Login getLoginById(Login l);
	public void deleteLogin(Login l);
	public void updateLogin(Login l);
}
