package com.revature.data;

import java.util.Set;

import com.revature.beans.Logintrip;

public interface LogintripDao {
	public int addLogintrip(Logintrip lt);
	public Set<Logintrip> getLogintrips();
	public void deleteLoginTrip(Logintrip lt);
	public Logintrip getLoginTrip(Integer tId, Integer uId);
}
