package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Logintrip;


@Service
public interface LogintripService {
	
	public Set<Logintrip> getLogintrips();
}
