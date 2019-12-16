package com.revature.services;

import java.util.Set;
import java.util.List;

import com.revature.beans.Message;

public interface MessageService {
	public Set<Message> getMsgByAskedId(Integer id);
	public Message getMessageById(Integer id);
	public Message updateMessage(Message m);
	public List<Message> getMessagesByAskerId(Integer id);
	public void addMessage(Message m);
}
