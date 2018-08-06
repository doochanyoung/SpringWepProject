package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.DataroomVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;
import com.java.persistence.DataroomCommentDAO;
import com.java.persistence.DataroomDAO;

@Service
public class DataroomServiceImpl implements DataroomService{
	
	@Inject
	private DataroomDAO dataroomDao;
	
	@Inject
	private DataroomCommentDAO dataroomCommentDao;

	@Transactional
	@Override
	public void regist(DataroomVO vo, int maxGroup) throws Exception {
		dataroomDao.create(vo, maxGroup);
		String[] files = vo.getFiles();
		if(files == null) {return;}
		for(String fileName : files) {
			dataroomDao.addAttach(fileName);
		}
	}

	@Override
	public void registReply(DataroomVO vo, int dataroomGroup, int maxSequence) throws Exception {
		dataroomDao.createReply(vo, dataroomGroup, maxSequence);
	}

	@Override
	public DataroomVO read(int dataroomId) throws Exception {
		return dataroomDao.read(dataroomId);
	}

	@Transactional
	@Override
	public void modify(DataroomVO vo) throws Exception {
		dataroomDao.update(vo);
		int dataroomId = vo.getDataroomId();
		dataroomDao.deleteAttach(dataroomId);
		String[] files = vo.getFiles();
		if(files == null) {return;}
		for(String fileName : files) {
			dataroomDao.replaceAttach(fileName, dataroomId);
		}
	}

	@Transactional
	@Override
	public void remove(int dataroomId) throws Exception {
		dataroomDao.deleteAttach(dataroomId);
		dataroomDao.delete(dataroomId);
		dataroomCommentDao.deleteComment(dataroomId);
	}

	@Override
	public List<DataroomVO> listAll() throws Exception {
		return dataroomDao.listAll();
	}

	@Override
	public int maxGroup() throws Exception {
		return dataroomDao.maxGroup();
	}

	@Override
	public int getGroup(int dataroomId) throws Exception {
		return dataroomDao.getGroup(dataroomId);
	}

	@Override
	public int maxSequence(int dataroomGroup) throws Exception {
		return dataroomDao.maxSequence(dataroomGroup);
	}

	@Override
	public List<DataroomVO> listPage(int page) throws Exception {
		return dataroomDao.listPage(page);
	}

	@Override
	public List<DataroomVO> listPageHandler(PageHandler handler) throws Exception {
		return dataroomDao.listPageHandler(handler);
	}

	@Override
	public int countPaging() throws Exception {
		return dataroomDao.countPaging();
	}

	@Override
	public List<DataroomVO> listSearchPageHandler(SearchPageHandler handler) throws Exception {
		return dataroomDao.listSearch(handler);
	}

	@Override
	public int searchCountPaging(SearchPageHandler handler) throws Exception {
		return dataroomDao.listSearchCount(handler);
	}
	

	@Override
	public void updateHit(int dataroomId) throws Exception {
		dataroomDao.updateHit(dataroomId);
	}

	@Override
	public void updateLike(int dataroomId) throws Exception {
		dataroomDao.updateLike(dataroomId);
	}

	@Override
	public List<String> getAttach(int dataroomId) throws Exception {
		return dataroomDao.getAttach(dataroomId);
	}

}
