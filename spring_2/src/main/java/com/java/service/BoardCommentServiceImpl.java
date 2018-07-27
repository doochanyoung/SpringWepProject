package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.BoardCommentVO;
import com.java.domain.PageHandler;
import com.java.persistence.BoardCommentDAO;
import com.java.persistence.BoardDAO;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {
	
	@Inject
	BoardCommentDAO commentDao;
	
	@Inject
	BoardDAO boardDao;

	@Override
	public List<BoardCommentVO> listComment(int boardId) throws Exception {
		return commentDao.list(boardId);
	}

	@Transactional
	@Override
	public void addComment(BoardCommentVO vo, int maxGroup) throws Exception {
		commentDao.create(vo, maxGroup);
		boardDao.updateCommCnt(vo.getBoardCommentBoardId(), 1);
	}

	@Transactional
	@Override
	public void addCommentReply(BoardCommentVO vo, int group, int sequence) throws Exception {
		commentDao.createReply(vo, group, sequence);
		boardDao.updateCommCnt(vo.getBoardCommentBoardId(), 1);
	}

	@Override
	public void modifyComment(BoardCommentVO vo) throws Exception {
		commentDao.update(vo);
	}

	@Transactional
	@Override
	public void removeComment(int boardCommentId) throws Exception {
		int boardId = commentDao.getBoardId(boardCommentId);
		commentDao.delete(boardCommentId);
		boardDao.updateCommCnt(boardId, -1);
	}

	@Override
	public int getMaxGroup(int boardId) throws Exception {
		return commentDao.maxGroup(boardId);
	}

	@Override
	public List<BoardCommentVO> listCommentPage(int boardId, PageHandler pageHandler) throws Exception {
		return commentDao.listPage(boardId, pageHandler);
	}

	@Override
	public int count(int boardId) throws Exception {
		return commentDao.count(boardId);
	}

	@Override
	public int getGroup(int boardCommentId) throws Exception {
		return commentDao.getGroup(boardCommentId);
	}

	@Override
	public int maxSequence(int boardCommentGroup) throws Exception {
		return commentDao.maxSequence(boardCommentGroup);
	}

}
