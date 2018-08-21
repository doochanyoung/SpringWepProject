package com.java.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;
import com.java.domain.MessageVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

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
    public List<MessageVO> readMessage(int mid){
    	return sqlSession.selectList(namespace + ".listAll");
    }
    // 메시지 열람시간 갱신
    @Override
    public void updateMessage(int mid){

    }
    
    @Override
	public List<MessageVO> listPage(int page) throws Exception {
		if(page <= 0) page = 1;
		page = (page - 1) * 30;
		return sqlSession.selectList(namespace + ".listPage", page);
	}
    
    @Override
	public List<MessageVO> listSearch(SearchPageHandler handler) throws Exception {
		return sqlSession.selectList(namespace + ".listSearch", handler);
	}
    
    @Override
	public List<MessageVO> listPageHandler(PageHandler handler) throws Exception {
		return sqlSession.selectList(namespace + ".listPageHandler", handler);
	}
    
    @Override
	public int countPaging() throws Exception {
		return sqlSession.selectOne(namespace + ".countPaging");
	}

    @Override
	public int listSearchCount(SearchPageHandler handler) throws Exception {
		return sqlSession.selectOne(namespace + ".listSearchCount", handler);
	}
}
