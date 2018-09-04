package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.domain.BoardVO;
import com.java.domain.MessageVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;
import com.java.persistence.MessageDAO;
import com.java.spring2.HomeController;

@Service
public class MessageServiceImpl implements MessageService {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
    private MessageDAO dao;

	
    @Override
    public void addMessage(MessageVO vo) {
        // 공통업무 - 로그 확인
        // 핵심업무 - 메시지 저장, 회원 포인트 적립
        // 메시지를 테이블에 저장
    	logger.info("messagerController");
    	
		dao.create(vo);
    }
    // 메시지 열람
    @Override
    public MessageVO readMessage(int messageId) {
    	return dao.readMessage(messageId);
    }
    
    @Override
	public List<MessageVO> listPageHandler(PageHandler handler) throws Exception {
		return dao.listPageHandler(handler);
	}
    
    @Override
	public List<MessageVO> listSearchPageHandler(SearchPageHandler handler) throws Exception {
		return dao.listSearch(handler);
	}
    
    @Override
	public int searchCountPaging(SearchPageHandler handler) throws Exception {
		return dao.listSearchCount(handler);
	}
}
