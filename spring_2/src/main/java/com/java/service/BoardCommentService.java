package com.java.service;

import java.util.List;

import com.java.domain.BoardCommentVO;
import com.java.domain.PageHandler;

public interface BoardCommentService {
	public List<BoardCommentVO> listComment(int boardId) throws Exception;
	public void addComment(BoardCommentVO vo, int maxGroup) throws Exception;
	public void addCommentReply(BoardCommentVO vo, int group, int sequence) throws Exception;
	public void modifyComment(BoardCommentVO vo) throws Exception;
	public void removeComment(int boardCommentId) throws Exception;
	public int getMaxGroup(int boardId) throws Exception;
	public List<BoardCommentVO> listCommentPage(int boardId, PageHandler pageHandler) throws Exception;
	public int count(int boardId) throws Exception;
}
