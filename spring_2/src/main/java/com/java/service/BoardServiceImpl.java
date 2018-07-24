package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.domain.BoardVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;
import com.java.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	private BoardDAO dao;

	@Override
	public void regist(BoardVO vo, int maxGroup) throws Exception {
		dao.create(vo, maxGroup);
	}

	@Override
	public void registReply(BoardVO vo, int boardGroup, int maxSequence) throws Exception {
		dao.createReply(vo, boardGroup, maxSequence);
	}

	@Override
	public BoardVO read(int boardId) throws Exception {
		return dao.read(boardId);
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(int boardId) throws Exception {
		dao.delete(boardId);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int maxGroup() throws Exception {
		return dao.maxGroup();
	}

	@Override
	public int getGroup(int boardId) throws Exception {
		return dao.getGroup(boardId);
	}

	@Override
	public int maxSequence(int boardGroup) throws Exception {
		return dao.maxSequence(boardGroup);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		return dao.listPage(page);
	}

	@Override
	public List<BoardVO> listPageHandler(PageHandler handler) throws Exception {
		return dao.listPageHandler(handler);
	}

	@Override
	public int countPaging() throws Exception {
		return dao.countPaging();
	}

	@Override
	public List<BoardVO> listSearchPageHandler(SearchPageHandler handler) throws Exception {
		return dao.listSearch(handler);
	}

	@Override
	public int searchCountPaging(SearchPageHandler handler) throws Exception {
		return dao.listSearchCount(handler);
	}

}
