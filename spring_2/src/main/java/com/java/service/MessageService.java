package com.java.service;

import java.util.List;

import com.java.domain.MessageVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface MessageService {
	public void addMessage(MessageVO vo);
	public MessageVO readMessage(int messageId);
	public List<MessageVO> listPageHandler(PageHandler handler) throws Exception;
	public List<MessageVO> listSearchPageHandler(SearchPageHandler handler) throws Exception;
	public int searchCountPaging(SearchPageHandler handler) throws Exception;
}
