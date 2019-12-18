package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Message;
import com.revature.data.MessageDao;
import com.revature.utils.HibernateUtil;

import com.revature.utils.LogUtil;

@Component
public class MessageHibernate implements MessageDao{
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();
  
	@Override
	public List<Message> getMsgByAskerId(Integer id) {
		Session s = hu.getSession();
		String query = "from Message m where m.askerId=:askerId";
		System.out.println("here");
		Query<Message> q = s.createQuery(query, Message.class);
		System.out.println("there");
		q.setParameter("askerId", id);
		List<Message> messages = q.list();
		s.close();
		return messages;
	}

	@Override
	public Set<Message> getMsgByAskedId(Integer id) {
		Session s = hu.getSession();
		String query = "from Message m where m.askedId = :askedId and m.status = 'pending'";
		Query<Message> q = s.createQuery(query, Message.class);
		q.setParameter("askedId", id);
		List<Message> messages = q.list();
		s.close();
		return new HashSet<Message>(messages);
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
	public Message getMessageById(Integer id) {
		Session s = hu.getSession();
		String query = "from Message m where m.id = :id";
		Query<Message> q = s.createQuery(query, Message.class);
		q.setParameter("id", id);
		Message m = q.uniqueResult();
		s.close();
		return m;
	}

	@Override
	public Message updateMessage(Message m) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(m);
			tx.commit();
		} catch(Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
		return m;
	}

	@Override
	public Message approveMessage(Integer askerId, Message m) {
		Session s = hu.getSession();
		// TODO: write the stored procedure here!
		return null;
	}
	
}
