package com.revature.services;

import java.util.Set;

import com.revature.beans.Message;

public interface MessageService {
	public Set<Message> getMsgByAskedId(Integer id);
}
