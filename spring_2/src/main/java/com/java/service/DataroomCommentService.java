package com.java.service;

import java.util.List;

import com.java.domain.BoardCommentVO;
import com.java.domain.DataroomCommentVO;
import com.java.domain.PageHandler;

public interface DataroomCommentService {
	public List<DataroomCommentVO> listComment(int dataroomId) throws Exception;
	public void addComment(DataroomCommentVO vo, int maxGroup) throws Exception;
	public void addCommentReply(DataroomCommentVO vo, int group, int sequence) throws Exception;
	public void modifyComment(DataroomCommentVO vo) throws Exception;
	public void removeComment(int dataroomCommentId) throws Exception;
	public int getMaxGroup(int dataroomId) throws Exception;
	public List<DataroomCommentVO> listCommentPage(int dataroomId, PageHandler pageHandler) throws Exception;
	public int count(int dataroomId) throws Exception;
	public int getGroup(int dataroomCommentId) throws Exception;
	public int maxSequence(int dataroomCommentGroup) throws Exception;
}
