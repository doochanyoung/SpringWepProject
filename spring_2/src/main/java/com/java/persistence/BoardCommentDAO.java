package com.java.persistence;

import java.util.List;

import com.java.domain.BoardCommentVO;
import com.java.domain.PageHandler;

public interface BoardCommentDAO {
	public List<BoardCommentVO> list(int boardId) throws Exception;
	public void create(BoardCommentVO vo, int maxGroup) throws Exception;
	public void createReply(BoardCommentVO vo, int group, int sequence) throws Exception;
	public void update(BoardCommentVO vo) throws Exception;
	public void delete(int boardCommentId) throws Exception;
	public int maxGroup(int boardId) throws Exception;
	public List<BoardCommentVO> listPage(int boardId, PageHandler pageHandler) throws Exception;
	public int count(int boardId) throws Exception;
	public int getGroup(int boardCommentId) throws Exception;
	public int maxSequence(int boardCommentGroup) throws Exception;
	public int getBoardId(int boardCommentId) throws Exception;
}

