package com.java.persistence;

import java.util.List;

import com.java.domain.BoardCommentVO;

public interface BoardCommentDAO {
	public List<BoardCommentVO> list(int boardCommentId) throws Exception;
	public void create(BoardCommentVO vo) throws Exception;
	public void update(BoardCommentVO vo) throws Exception;
	public void delete(int boardCommentId) throws Exception;
}
