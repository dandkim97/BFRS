package com.revature.services.hibernate;

import java.util.Set;



import com.revature.beans.Logintrip;
import com.revature.data.LogintripDao;
import com.revature.data.hibernate.LogintripHibernate;
import com.revature.services.LogintripService;

public class LogintripServiceHibernate implements LogintripService {
	
	private static LogintripDao ld = new LogintripHibernate();
	
	@Override
	public void addLogintrip(Logintrip lt) {
		ld.addLogintrip(lt);
	}
	
	@Override
	public Set<Logintrip> getLogintrips() {		
		return ld.getLogintrips();
	}
}
