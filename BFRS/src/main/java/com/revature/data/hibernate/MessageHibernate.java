package com.revature.data.hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Message;
import com.revature.data.MessageDao;
import com.revature.utils.HibernateUtil;

@Component
public class MessageHibernate implements MessageDao{
	
	@Autowired
	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public Set<Message> getMsgByAskerId(Integer id) {
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMessage(Message m) {
		// TODO Auto-generated method stub
		
	}
	
}
