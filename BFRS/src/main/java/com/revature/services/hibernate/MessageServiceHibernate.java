package com.revature.services.hibernate;

import java.util.Set;
import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Message;
import com.revature.data.MessageDao;
import com.revature.data.hibernate.MessageHibernate;
import com.revature.services.MessageService;

@Service
public class MessageServiceHibernate implements MessageService{
	
	private MessageDao md = new MessageHibernate();

	@Override
	public Set<Message> getMsgByAskedId(Integer id) {
		return md.getMsgByAskedId(id);
	}
  
	@Override
	public Message getMessageById(Integer id) {
		return md.getMessageById(id);
	}
  
	@Override
	public Message updateMessage(Message m) {
		return md.updateMessage(m);
	}
  
	@Override
	public List<Message> getMessagesByAskerId(Integer id) {
		return md.getMsgByAskerId(id);
	}
  
	@Override
	public void addMessage(Message m) {
		md.addMessage(m);
	}

}
