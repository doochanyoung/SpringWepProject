package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.domain.BoardVO;
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
	public void registReply(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BoardVO read(int boardId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int boardId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int maxGroup() throws Exception {
		return dao.maxGroup();
	}
	
	
}
