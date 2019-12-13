package com.revature.data.hibernate;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Message;
import com.revature.data.MessageDao;
import com.revature.utils.HibernateUtil;
import com.revature.utils.LogUtil;

public class MessageHibernate implements MessageDao{
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public Set<Message> getMsgByAskerId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Message> getMsgByAskedId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMessage(Message m) {
		Session s = hu.getSession();
		Transaction t = null;
		try {
			t = s.beginTransaction();
			@SuppressWarnings("unused")
			Integer i = (Integer) s.save(m);
			t.commit();
		} catch (HibernateException e) {
			t.rollback();
			LogUtil.logException(e, MessageHibernate.class);
		} finally {
			s.close();
		}
		
	}

	@Override
	public void updateMessage(Message m) {
		// TODO Auto-generated method stub
		
	}
	
}
