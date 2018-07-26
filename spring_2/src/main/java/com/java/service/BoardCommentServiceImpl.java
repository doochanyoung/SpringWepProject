package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.domain.BoardCommentVO;
import com.java.domain.PageHandler;
import com.java.persistence.BoardCommentDAO;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	
	@Inject
	BoardCommentDAO dao;

	@Override
	public List<BoardCommentVO> listComment(int boardId) throws Exception {
		return dao.list(boardId);
	}

	@Override
	public void addComment(BoardCommentVO vo, int maxGroup) throws Exception {
		dao.create(vo, maxGroup);
	}

	@Override
	public void addCommentReply(BoardCommentVO vo, int group, int sequence) throws Exception {
		dao.createReply(vo, group, sequence);
	}

	@Override
	public void modifyComment(BoardCommentVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void removeComment(int boardCommentId) throws Exception {
		dao.delete(boardCommentId);
	}

	@Override
	public int getMaxGroup(int boardId) throws Exception {
		return dao.maxGroup(boardId);
	}

	@Override
	public List<BoardCommentVO> listCommentPage(int boardId, PageHandler pageHandler) throws Exception {
		return dao.listPage(boardId, pageHandler);
	}

	@Override
	public int count(int boardId) throws Exception {
		return dao.count(boardId);
	}

	@Override
	public int getGroup(int boardCommentId) throws Exception {
		return dao.getGroup(boardCommentId);
	}

	@Override
	public int maxSequence(int boardCommentGroup) throws Exception {
		return dao.maxSequence(boardCommentGroup);
	}

}
