package com.java.persistence;

import java.util.List;

import com.java.domain.BoardVO;

public interface BoardDAO {
	public void create(BoardVO vo, int maxGroup) throws Exception;
	public void createReply(BoardVO vo) throws Exception;
	public BoardVO read(int boardId) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int boardId) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public int maxGroup() throws Exception;
}
