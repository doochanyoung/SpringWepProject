package com.java.persistence;

import java.util.List;

import com.java.domain.DataroomCommentVO;
import com.java.domain.PageHandler;

public interface DataroomCommentDAO {
	public List<DataroomCommentVO> list(int dataroomId) throws Exception;
	public void create(DataroomCommentVO vo, int maxGroup) throws Exception;
	public void createReply(DataroomCommentVO vo, int group, int sequence) throws Exception;
	public void update(DataroomCommentVO vo) throws Exception;
	public void delete(int dataroomCommentId) throws Exception;
	public int maxGroup(int dataroomId) throws Exception;
	public List<DataroomCommentVO> listPage(int dataroomId, PageHandler pageHandler) throws Exception;
	public int count(int dataroomId) throws Exception;
	public int getGroup(int dataroomCommentId) throws Exception;
	public int maxSequence(int dataroomCommentGroup) throws Exception;
	public int getBoardId(int dataroomCommentId) throws Exception;
	public void deleteComment(int dataroomCommentBoardId) throws Exception;
}

