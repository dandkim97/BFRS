package com.revature.data;

import java.util.Set;

import com.revature.beans.Message;

public interface MessageDao {
	public Set<Message> getMsgByAskerId(Integer id);
	public Set<Message> getMsgByAskedId(Integer id);
	public void addMessage(Message m);
	public Message getMessageById(Integer id);
	public Message updateMessage(Message m);
}
