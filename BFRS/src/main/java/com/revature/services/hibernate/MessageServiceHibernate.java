package com.revature.services.hibernate;

import org.springframework.stereotype.Service;

import com.revature.data.MessageDao;
import com.revature.data.hibernate.MessageHibernate;
import com.revature.services.MessageService;

@Service
public class MessageServiceHibernate implements MessageService{
	
	private MessageDao md = new MessageHibernate();
}
