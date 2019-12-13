package com.revature.services;

import java.util.Set;

import com.revature.beans.Message;

public interface MessageService {
	public Set<Message> getMessagesByAskerId(Integer id);
	public void updateMessage(Message m);
	public void addMessage(Message m);
}
