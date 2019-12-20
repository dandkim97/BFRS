package com.revature.data;

import java.util.Set;

import com.revature.beans.Logintrip;

public interface LogintripDao {
	public int addLogintrip(Logintrip lt);
	public Set<Logintrip> getLogintrips();
}
