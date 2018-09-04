package com.java.persistence;

import java.util.List;

import com.java.domain.MessageVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface MessageDAO {
	 public void create(MessageVO vo);
	 public MessageVO readMessage(int mid);
	 public void updateMessage(int messageId);
	 public List<MessageVO> listPage(int page) throws Exception;
	 public List<MessageVO> listSearch(SearchPageHandler handler) throws Exception;
	 public List<MessageVO> listPageHandler(PageHandler handler) throws Exception;
	 public int countPaging() throws Exception;
	 public int listSearchCount(SearchPageHandler handler) throws Exception;
}