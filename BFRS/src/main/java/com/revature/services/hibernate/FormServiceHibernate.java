package com.revature.services.hibernate;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.beans.Form;
import com.revature.data.FormDao;
import com.revature.data.hibernate.FormHibernate;
import com.revature.services.FormService;

@Service
public class FormServiceHibernate implements FormService {
	
	@Autowired
	private static FormDao fd = new FormHibernate();

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
	public Form updateForm(Form f) {
		return fd.updateForm(f);
	}

	@Override
	public void deleteForm(Form f) {
		fd.deleteForm(f);
	}

}
