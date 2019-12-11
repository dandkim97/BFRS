package com.revature.services.hibernate;

import java.util.Set;

import com.revature.beans.Form;
import com.revature.data.FormDAO;
import com.revature.data.hibernate.FormHibernate;
import com.revature.services.FormService;

public class FormServiceHibernate implements FormService {
	private static FormDAO fd = new FormHibernate();

	@Override
	public void addForm(Form f) {
		fd.addForm(f);
	}

	@Override
	public Form getFormById(int id) {
		return fd.getForm(id);
	}

	@Override
	public Set<Form> getForms() {
		return fd.getForms();
	}

	@Override
	public void updateForm(Form f) {
		fd.updateForm(f);
	}

	@Override
	public void deleteForm(Form f) {
		fd.deleteForm(f);
	}

}
