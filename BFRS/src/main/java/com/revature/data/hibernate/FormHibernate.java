package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Form;
import com.revature.data.FormDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

@Component
public class FormHibernate implements FormDao {
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public int addForm(Form f) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(f);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, FormHibernate.class);
		} finally {
			s.close();
		}
		return f.getId();
	}

	@Override
	public Form getForm(int i) {
		Session s = hu.getSession();
		Form f = s.get(Form.class, i);
		s.close();
		return f;
	}

	@Override
	public Set<Form> getForms() {
		Session s = hu.getSession();
		String query = "FROM Form";
		Query<Form> q = s.createQuery(query, Form.class);
		List<Form> formList = q.getResultList();
		Set<Form> formSet = new HashSet<Form>();
		formSet.addAll(formList);
		s.close();
		return formSet;
	}

	@Override
	public Form updateForm(Form f) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(f);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, FormHibernate.class);
		} finally {
			s.close();
		}
		return f;
	}

	@Override
	public void deleteForm(Form f) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(f);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			LogUtil.logException(e, FormHibernate.class);
		} finally {
			s.close();
		}
	}

}
