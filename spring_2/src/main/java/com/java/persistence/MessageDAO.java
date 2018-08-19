package com.java.persistence;

import com.java.domain.MessageVO;

public interface MessageDAO {
	 public void create(MessageVO vo);
	 public MessageVO readMessage(int mid);
	 public void updateMessage(int mid);
}
