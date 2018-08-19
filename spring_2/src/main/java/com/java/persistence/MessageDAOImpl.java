package com.java.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
    @Inject
    private SqlSession sqlSession;
    
    private static String namespace = "com.java.mapper.messageMapper";

    // 메시지 작성
    @Override
    public void create(MessageVO vo){
        sqlSession.insert(namespace+".create", vo);
    }
    // 메시지 열람
    @Override
    public MessageVO readMessage(int mid){
    	//sqlSession.select("message.read", mid);
        return null;
    }
    // 메시지 열람시간 갱신
    @Override
    public void updateMessage(int mid){

    }
}
