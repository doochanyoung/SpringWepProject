package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.DataroomCommentVO;
import com.java.domain.PageHandler;
import com.java.persistence.DataroomCommentDAO;
import com.java.persistence.DataroomDAO;

@Service
public class DataroomCommentServiceImpl implements DataroomCommentService {
	
	@Inject
	DataroomCommentDAO commentDao;
	
	@Inject
	DataroomDAO dataroomDao;

	@Override
	public List<DataroomCommentVO> listComment(int dataroomId) throws Exception {
		return commentDao.list(dataroomId);
	}

	@Transactional
	@Override
	public void addComment(DataroomCommentVO vo, int maxGroup) throws Exception {
		commentDao.create(vo, maxGroup);
		dataroomDao.updateCommCnt(vo.getDataroomCommentBoardId(), 1);
	}

	@Transactional
	@Override
	public void addCommentReply(DataroomCommentVO vo, int group, int sequence) throws Exception {
		commentDao.createReply(vo, group, sequence);
		dataroomDao.updateCommCnt(vo.getDataroomCommentBoardId(), 1);
	}

	@Override
	public void modifyComment(DataroomCommentVO vo) throws Exception {
		commentDao.update(vo);
	}

	@Transactional
	@Override
	public void removeComment(int dataroomCommentId) throws Exception {
		int dataroomId = commentDao.getBoardId(dataroomCommentId);
		commentDao.delete(dataroomCommentId);
		dataroomDao.updateCommCnt(dataroomId, -1);
	}

	@Override
	public int getMaxGroup(int dataroomId) throws Exception {
		return commentDao.maxGroup(dataroomId);
	}

	@Override
	public List<DataroomCommentVO> listCommentPage(int dataroomId, PageHandler pageHandler) throws Exception {
		return commentDao.listPage(dataroomId, pageHandler);
	}

	@Override
	public int count(int dataroomId) throws Exception {
		return commentDao.count(dataroomId);
	}

	@Override
	public int getGroup(int dataroomCommentId) throws Exception {
		return commentDao.getGroup(dataroomCommentId);
	}

	@Override
	public int maxSequence(int dataroomCommentGroup) throws Exception {
		return commentDao.maxSequence(dataroomCommentGroup);
	}

}
