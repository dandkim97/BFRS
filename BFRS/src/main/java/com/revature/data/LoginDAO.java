package com.revature.data;

import com.revature.beans.Login;

public interface LoginDAO {
	public Login getLogin(String username, String password);
}
