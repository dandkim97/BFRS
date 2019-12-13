package com.revature.data;

import java.util.List;

import com.revature.beans.Message;

public interface MessageDao {
	public List<Message> getMsgByAskerId(Integer id);
	public List<Message> getMsgByAskedId(Integer id);
	public void addMessage(Message m);
	public void updateMessage(Message m);
}
