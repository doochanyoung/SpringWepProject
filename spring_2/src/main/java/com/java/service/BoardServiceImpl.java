package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.BoardVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;
import com.java.persistence.BoardCommentDAO;
import com.java.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO boardDao;
	
	@Inject
	private BoardCommentDAO boardCommentDao;

	@Override
	public void regist(BoardVO vo, int maxGroup) throws Exception {
		boardDao.create(vo, maxGroup);
	}

	@Override
	public void registReply(BoardVO vo, int boardGroup, int maxSequence) throws Exception {
		boardDao.createReply(vo, boardGroup, maxSequence);
	}

	@Override
	public BoardVO read(int boardId) throws Exception {
		return boardDao.read(boardId);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		boardDao.update(vo);
	}

	@Transactional
	@Override
	public void remove(int boardId) throws Exception {
		boardDao.delete(boardId);
		boardCommentDao.deleteComment(boardId);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}

	@Override
	public int maxGroup() throws Exception {
		return boardDao.maxGroup();
	}

	@Override
	public int getGroup(int boardId) throws Exception {
		return boardDao.getGroup(boardId);
	}

	@Override
	public int maxSequence(int boardGroup) throws Exception {
		return boardDao.maxSequence(boardGroup);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		return boardDao.listPage(page);
	}

	@Override
	public List<BoardVO> listPageHandler(PageHandler handler) throws Exception {
		return boardDao.listPageHandler(handler);
	}

	@Override
	public int countPaging() throws Exception {
		return boardDao.countPaging();
	}

	@Override
	public List<BoardVO> listSearchPageHandler(SearchPageHandler handler) throws Exception {
		return boardDao.listSearch(handler);
	}

	@Override
	public int searchCountPaging(SearchPageHandler handler) throws Exception {
		return boardDao.listSearchCount(handler);
	}
	

	@Override
	public void updateHit(int boardId) throws Exception {
		boardDao.updateHit(boardId);
	}

	@Override
	public void updateLike(int boardId) throws Exception {
		boardDao.updateLike(boardId);
	}

}
