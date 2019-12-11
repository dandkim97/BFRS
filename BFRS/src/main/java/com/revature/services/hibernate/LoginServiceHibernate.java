package com.revature.services.hibernate;

import java.util.Set;

import com.revature.beans.Login;
import com.revature.data.LoginDao;
import com.revature.data.hibernate.LoginHibernate;
import com.revature.services.LoginService;

public class LoginServiceHibernate implements LoginService{
	
	private LoginDao ld = new LoginHibernate();

	@Override
	public Login getLogin(String username, String pswrd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login getLoginById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Login> getLogins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLogin(Login l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLogin(Login l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLogin(Login l) {
		l.setIs_admin(0);
		l.setLoyalty_status(0);
		ld.addLogin(l);
		
	}

}
