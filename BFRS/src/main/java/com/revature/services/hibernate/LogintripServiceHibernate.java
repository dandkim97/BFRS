package com.revature.services.hibernate;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Logintrip;
import com.revature.data.LogintripDao;
import com.revature.data.hibernate.LogintripHibernate;
import com.revature.services.LogintripService;

@Service
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
