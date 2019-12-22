package com.revature.services;

import java.util.Set;

import com.revature.beans.Logintrip;

public interface LogintripService {
	public void addLogintrip(Logintrip lt);
	public Set<Logintrip> getLogintrips();
}
