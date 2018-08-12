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
		paramMap.put("title", vo.getBoardTitle());
		paramMap.put("content", vo.getBoardContent());
		paramMap.put("userId", vo.getBoardUserId());
		paramMap.put("maxGroup", maxGroup + 1);
		session.insert(namespace + ".create", paramMap);
	}

	@Override
	public void createReply(BoardVO vo, int boardGroup, int maxSequence) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getBoardTitle());
		paramMap.put("content", vo.getBoardContent());
		paramMap.put("userId", vo.getBoardUserId());
		paramMap.put("group", boardGroup);
		paramMap.put("sequence", maxSequence + 1);
		session.insert(namespace + ".createReply", paramMap);
	}

	@Override
	public BoardVO read(int boardId) throws Exception {
		return session.selectOne(namespace + ".read", boardId);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getBoardTitle());
		paramMap.put("content", vo.getBoardContent());
		paramMap.put("boardId", vo.getBoardId());
		session.update(namespace + ".update", paramMap);
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
		if(countPaging() == 0) {
			return 0;
		}
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
	
	@Override
	public void updateCommCnt(int boardId, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardId", boardId);
		paramMap.put("amount", amount);
		session.update(namespace + ".updateCommCnt", paramMap);
	}
	
	@Override
	public void updateHit(int boardId) throws Exception {
		session.update(namespace + ".updateHit", boardId);
	}

	@Override
	public void updateLike(int boardId) throws Exception {
		session.update(namespace + ".updateLike", boardId);
	}

	@Override
	public void addAttach(String fullName) throws Exception {
		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(int boardId) throws Exception {
		return session.selectList(namespace + ".getAttach", boardId);
	}

	@Override
	public void deleteAttach(int boardId) throws Exception {
		session.delete(namespace + ".deleteAttach", boardId);
	}

	@Override
	public void replaceAttach(String fullName, int boardId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardId", boardId);
		paramMap.put("fullName", fullName);
		session.update(namespace + ".replaceAttach", paramMap);
	}

}
