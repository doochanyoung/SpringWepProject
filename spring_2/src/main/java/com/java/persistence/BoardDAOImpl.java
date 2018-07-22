package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;

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
		System.out.println(paramMap);
		session.insert(namespace + ".create", paramMap);
	}

	@Override
	public void createReply(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO read(int boardId) throws Exception {
		return session.selectOne(namespace + ".read", boardId);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int boardId) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public int maxGroup() throws Exception {
		return session.selectOne(namespace + ".maxGroup");
	}

}
