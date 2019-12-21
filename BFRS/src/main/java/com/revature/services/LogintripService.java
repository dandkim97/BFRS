package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Logintrip;

@Service
public interface LogintripService {
	public void addLogintrip(Logintrip lt);
	public Set<Logintrip> getLogintrips();
}
