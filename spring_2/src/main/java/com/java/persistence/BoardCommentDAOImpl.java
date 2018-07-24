package com.java.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardCommentVO;

@Repository
public class BoardCommentDAOImpl implements BoardCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.BoardCommentMapper"; 

	@Override
	public List<BoardCommentVO> list(int boardCommentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(BoardCommentVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BoardCommentVO vo) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int boardCommentId) throws Exception {
		// TODO Auto-generated method stub

	}

}
