package com.revature.services.hibernate;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Message;
import com.revature.data.MessageDao;
import com.revature.data.hibernate.MessageHibernate;
import com.revature.services.MessageService;

@Service
public class MessageServiceHibernate implements MessageService{
	
	private MessageDao md = new MessageHibernate();

	@Override
	public Set<Message> getMessagesByAskerId(Integer id) {
		return md.getMsgByAskerId(id);
	}

	@Override
	public void updateMessage(Message m) {
		md.updateMessage(m);
		
	}

	@Override
	public void addMessage(Message m) {
		md.addMessage(m);
		
	}
	
}
