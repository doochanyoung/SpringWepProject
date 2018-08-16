package com.java.service;

import com.java.domain.MessageVO;

public interface MessageService {
	public void addMessage(MessageVO vo);
	public MessageVO readMessage(String userid, int mid);
}
