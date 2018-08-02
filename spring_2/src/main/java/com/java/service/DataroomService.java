package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.DataroomVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface DataroomService {
	public void regist(DataroomVO vo, int maxGroup) throws Exception;
	public void registReply(DataroomVO vo, int dataroomGroup, int maxSequence) throws Exception;
	public DataroomVO read(int dataroomId) throws Exception;
	public void modify(DataroomVO vo) throws Exception;
	public void remove(int dataroomId) throws Exception;
	public List<DataroomVO> listAll() throws Exception;
	public int maxGroup() throws Exception;
	public int maxSequence(int dataroomGroup) throws Exception;
	public int getGroup(int dataroomId) throws Exception;
	public List<DataroomVO> listPage(int page) throws Exception;
	public List<DataroomVO> listPageHandler(PageHandler handler) throws Exception;
	public int countPaging() throws Exception;
	public List<DataroomVO> listSearchPageHandler(SearchPageHandler handler) throws Exception;
	public int searchCountPaging(SearchPageHandler handler) throws Exception;
	public void updateHit(int dataroomId) throws Exception;
	public void updateLike(int dataroomId) throws Exception;
	public List<String> getAttach(int dataroomId) throws Exception;
}
