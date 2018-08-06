package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardCommentVO;
import com.java.domain.DataroomCommentVO;
import com.java.domain.PageHandler;

@Repository
public class DataroomCommentDAOImpl implements DataroomCommentDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.DataroomCommentMapper"; 

	@Override
	public List<DataroomCommentVO> list(int dataroomId) throws Exception {
		return session.selectList(namespace + ".list", dataroomId);
	}

	@Override
	public void create(DataroomCommentVO vo, int maxGroup) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("content", vo.getDataroomCommentContent());
		paramMap.put("maxGroup", maxGroup + 1);
		paramMap.put("dataroomId", vo.getDataroomCommentBoardId());
		paramMap.put("userId", vo.getDataroomCommentUserId());
		session.insert(namespace + ".create", paramMap);
	}
	
	@Override
	public void createReply(DataroomCommentVO vo, int group, int sequence) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("content", vo.getDataroomCommentContent());
		paramMap.put("userId", vo.getDataroomCommentUserId());
		paramMap.put("dataroomId", vo.getDataroomCommentBoardId());
		paramMap.put("group", group);
		paramMap.put("sequence", sequence + 1);
		session.insert(namespace + ".createReply", paramMap);
	}

	@Override
	public void update(DataroomCommentVO vo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dataroomCommentId", vo.getDataroomCommentId());
		paramMap.put("dataroomCommentContent", vo.getDataroomCommentContent());
		session.update(namespace + ".update", paramMap);
	}

	@Override
	public void delete(int dataroomCommentId) throws Exception {
		session.delete(namespace + ".delete", dataroomCommentId);
	}

	@Override
	public int maxGroup(int dataroomId) throws Exception {
		if(count(dataroomId) == 0) {
			return 0;
		}
		return session.selectOne(namespace + ".maxGroup", dataroomId);
	}

	@Override
	public List<DataroomCommentVO> listPage(int dataroomId, PageHandler pageHandler) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dataroomId", dataroomId);
		paramMap.put("pageStart", pageHandler.getPageStart());
		paramMap.put("perPageNum", pageHandler.getPerPageNum());
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(int dataroomId) throws Exception {
		return session.selectOne(namespace + ".count", dataroomId);
	}

	@Override
	public int getGroup(int dataroomCommentId) throws Exception {
		return session.selectOne(namespace + ".getGroup", dataroomCommentId);
	}

	@Override
	public int maxSequence(int dataroomCommentGroup) throws Exception {
		return session.selectOne(namespace + ".maxSequence", dataroomCommentGroup);
	}

	@Override
	public int getBoardId(int dataroomCommentId) throws Exception {
		return session.selectOne(namespace + ".getBoardId", dataroomCommentId);
	}

	@Override
	public void deleteComment(int dataroomCommentBoardId) throws Exception {
		session.delete(namespace + ".deleteComment", dataroomCommentBoardId);
	}


}
