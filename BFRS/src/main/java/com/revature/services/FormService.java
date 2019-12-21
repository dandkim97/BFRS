package com.revature.services;

import java.util.Set;

import com.revature.beans.Form;

public interface FormService {
	public void addForm(Form f);
	public Form getFormById(int id);
	public Set<Form> getForms();
	public Form updateForm(Form f);
	public void deleteForm(Form f);
}
