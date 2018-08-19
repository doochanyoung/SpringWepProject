package com.java.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.domain.MessageVO;
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
    public MessageVO readMessage(String userid, int mid) {

        return null;
    }
}
