package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
    public MessageVO readMessage(int mid){
    	return sqlSession.selectOne(namespace + ".read", mid);
    }
    // 메시지 열람시간 갱신
    @Override
    public void updateMessage(int messageId){
    	sqlSession.update(namespace+".update", messageId);
    }
    
    @Override
	public List<MessageVO> listPage(int page) throws Exception {
		if(page <= 0) page = 1;
		page = (page - 1) * 30;
		return sqlSession.selectList(namespace + ".listPage", page);
	}
    
    @Override
	public List<MessageVO> listSearch(SearchPageHandler handler, String loginId) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("searchType", handler.getSearchType());
    	paramMap.put("keyword", handler.getKeyword());
    	paramMap.put("searchSort", handler.getSearchSort());
    	paramMap.put("loginId", loginId);
		return sqlSession.selectList(namespace + ".listSearch", paramMap);
	}
    
    @Override
	public List<MessageVO> listPageHandler(PageHandler handler, String loginId) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("page", handler.getPage());
    	paramMap.put("perPageNum", handler.getPerPageNum());
    	paramMap.put("loginId", loginId);
    	return sqlSession.selectList(namespace + ".listPageHandler", paramMap);
	}
    
    @Override
	public int countPaging() throws Exception {
		return sqlSession.selectOne(namespace + ".countPaging");
	}

    @Override
	public int listSearchCount(SearchPageHandler handler, String loginId) throws Exception {
    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	paramMap.put("searchType", handler.getSearchType());
    	paramMap.put("keyword", handler.getKeyword());
    	paramMap.put("searchSort", handler.getSearchSort());
    	paramMap.put("loginId", loginId);
		return sqlSession.selectOne(namespace + ".countPaging", paramMap);
	}
}
