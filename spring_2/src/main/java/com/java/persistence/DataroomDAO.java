package com.java.persistence;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.DataroomVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface DataroomDAO {
	public void create(DataroomVO vo, int maxGroup) throws Exception;
	public void createReply(DataroomVO vo, int dataroomGroup, int maxSequence) throws Exception;
	public DataroomVO read(int dataroomId) throws Exception;
	public void update(DataroomVO vo) throws Exception;
	public void delete(int dataroomId) throws Exception;
	public List<DataroomVO> listAll() throws Exception;
	public int maxGroup() throws Exception;
	public int getGroup(int dataroomId) throws Exception;
	public int maxSequence(int dataroomGroup) throws Exception;
	public List<DataroomVO> listPage(int page) throws Exception;
	public List<DataroomVO> listPageHandler(PageHandler handler) throws Exception;
	public int countPaging() throws Exception;
	public List<DataroomVO> listSearch(SearchPageHandler handler) throws Exception;
	public int listSearchCount(SearchPageHandler handler) throws Exception;
	public void updateCommCnt(int dataroomId, int amount) throws Exception;
	public void updateHit(int dataroomId) throws Exception;
	public void updateLike(int dataroomId) throws Exception;
	public void addAttach(String fullName) throws Exception;
}
