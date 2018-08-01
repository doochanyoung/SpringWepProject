package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.DataroomVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;
import com.java.persistence.DataroomDAO;

@Service
public class DataroomServiceImpl implements DataroomService{
	
	@Inject
	private DataroomDAO dao;

	@Transactional
	@Override
	public void regist(DataroomVO vo, int maxGroup) throws Exception {
		dao.create(vo, maxGroup);
		String[] files = vo.getFiles();
		if(files == null) {return;}
		for(String fileName : files) {
			dao.addAttach(fileName);
		}
	}

	@Override
	public void registReply(DataroomVO vo, int dataroomGroup, int maxSequence) throws Exception {
		dao.createReply(vo, dataroomGroup, maxSequence);
	}

	@Override
	public DataroomVO read(int dataroomId) throws Exception {
		return dao.read(dataroomId);
	}

	@Override
	public void modify(DataroomVO vo) throws Exception {
		dao.update(vo);
	}

	@Override
	public void remove(int dataroomId) throws Exception {
		dao.delete(dataroomId);
	}

	@Override
	public List<DataroomVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public int maxGroup() throws Exception {
		return dao.maxGroup();
	}

	@Override
	public int getGroup(int dataroomId) throws Exception {
		return dao.getGroup(dataroomId);
	}

	@Override
	public int maxSequence(int dataroomGroup) throws Exception {
		return dao.maxSequence(dataroomGroup);
	}

	@Override
	public List<DataroomVO> listPage(int page) throws Exception {
		return dao.listPage(page);
	}

	@Override
	public List<DataroomVO> listPageHandler(PageHandler handler) throws Exception {
		return dao.listPageHandler(handler);
	}

	@Override
	public int countPaging() throws Exception {
		return dao.countPaging();
	}

	@Override
	public List<DataroomVO> listSearchPageHandler(SearchPageHandler handler) throws Exception {
		return dao.listSearch(handler);
	}

	@Override
	public int searchCountPaging(SearchPageHandler handler) throws Exception {
		return dao.listSearchCount(handler);
	}
	

	@Override
	public void updateHit(int dataroomId) throws Exception {
		dao.updateHit(dataroomId);
	}

	@Override
	public void updateLike(int dataroomId) throws Exception {
		dao.updateLike(dataroomId);
	}

}
