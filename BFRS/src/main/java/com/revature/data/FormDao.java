package com.revature.data;

import java.util.Set;

import com.revature.beans.Form;

public interface FormDao {
	public int addForm(Form f);
	public Form getForm(int i);
	public Form getForm(Integer tId, Integer uId);
	public Set<Form> getForms();
	public Form updateForm(Form f);
	public void deleteForm(Form f);
}
