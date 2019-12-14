package com.revature.services;

public interface MessageService {
	
import java.util.List;

import com.revature.beans.Message;

public interface MessageService {
	public List<Message> getMessagesByAskerId(Integer id);
	public void updateMessage(Message m);
	public void addMessage(Message m);
}
