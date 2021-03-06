package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardCommentVO;
import com.java.domain.PageHandler;

@Repository
public class BoardCommentDAOImpl implements BoardCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.BoardCommentMapper"; 

	@Override
	public List<BoardCommentVO> list(int boardId) throws Exception {
		return session.selectList(namespace + ".list", boardId);
	}

	@Override
	public void create(BoardCommentVO vo, int maxGroup) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("content", vo.getBoardCommentContent());
		paramMap.put("maxGroup", maxGroup + 1);
		paramMap.put("boardId", vo.getBoardCommentBoardId());
		paramMap.put("userId", vo.getBoardCommentUserId());
		session.insert(namespace + ".create", paramMap);
	}
	
	@Override
	public void createReply(BoardCommentVO vo, int group, int sequence) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("content", vo.getBoardCommentContent());
		paramMap.put("userId", vo.getBoardCommentUserId());
		paramMap.put("boardId", vo.getBoardCommentBoardId());
		paramMap.put("group", group);
		paramMap.put("sequence", sequence + 1);
		session.insert(namespace + ".createReply", paramMap);
	}

	@Override
	public void update(BoardCommentVO vo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardCommentId", vo.getBoardCommentId());
		paramMap.put("boardCommentContent", vo.getBoardCommentContent());
		session.update(namespace + ".update", paramMap);
	}

	@Override
	public void delete(int boardCommentId) throws Exception {
		session.delete(namespace + ".delete", boardCommentId);
	}

	@Override
	public int maxGroup(int boardId) throws Exception {
		if(count(boardId) == 0) {
			return 0;
		}
		return session.selectOne(namespace + ".maxGroup", boardId);
	}

	@Override
	public List<BoardCommentVO> listPage(int boardId, PageHandler pageHandler) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("boardId", boardId);
		paramMap.put("pageStart", pageHandler.getPageStart());
		paramMap.put("perPageNum", pageHandler.getPerPageNum());
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(int boardId) throws Exception {
		return session.selectOne(namespace + ".count", boardId);
	}

	@Override
	public int getGroup(int boardCommentId) throws Exception {
		return session.selectOne(namespace + ".getGroup", boardCommentId);
	}

	@Override
	public int maxSequence(int boardCommentGroup) throws Exception {
		return session.selectOne(namespace + ".maxSequence", boardCommentGroup);
	}

	@Override
	public int getBoardId(int boardCommentId) throws Exception {
		return session.selectOne(namespace + ".getBoardId", boardCommentId);
	}

	@Override
	public void deleteComment(int boardCommentBoardId) throws Exception {
		session.delete(namespace + ".deleteComment", boardCommentBoardId);
	}


}
