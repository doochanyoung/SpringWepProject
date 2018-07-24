package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.BoardMapper"; 

	@Override
	public void create(BoardVO vo, int maxGroup) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardTitle", vo.getBoardTitle());
		paramMap.put("boardContent", vo.getBoardContent());
		paramMap.put("boardUserId", vo.getBoardUserId());
		paramMap.put("maxGroup", maxGroup + 1);
		session.insert(namespace + ".create", paramMap);
	}

	@Override
	public void createReply(BoardVO vo, int boardGroup, int maxSequence) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardTitle", vo.getBoardTitle());
		paramMap.put("boardContent", vo.getBoardContent());
		paramMap.put("boardUserId", vo.getBoardUserId());
		paramMap.put("boardGroup", boardGroup);
		paramMap.put("boardSequence", maxSequence + 1);
		session.insert(namespace + ".createReply", paramMap);
	}

	@Override
	public BoardVO read(int boardId) throws Exception {
		return session.selectOne(namespace + ".read", boardId);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(int boardId) throws Exception {
		session.delete(namespace + ".delete", boardId);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public int maxGroup() throws Exception {
		return session.selectOne(namespace + ".maxGroup");
	}

	@Override
	public int getGroup(int boardId) throws Exception {
		return session.selectOne(namespace + ".getGroup", boardId);
	}

	@Override
	public int maxSequence(int boardGroup) throws Exception {
		return session.selectOne(namespace + ".maxSequence", boardGroup);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0) page = 1;
		page = (page - 1) * 30;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BoardVO> listPageHandler(PageHandler handler) throws Exception {
		return session.selectList(namespace + ".listPageHandler", handler);
	}

	@Override
	public int countPaging() throws Exception {
		return session.selectOne(namespace + ".countPaging");
	}

	@Override
	public List<BoardVO> listSearch(SearchPageHandler handler) throws Exception {
		return session.selectList(namespace + ".listSearch", handler);
	}

	@Override
	public int listSearchCount(SearchPageHandler handler) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", handler);
	}

}
