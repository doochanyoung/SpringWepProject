package com.java.persistence;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface BoardDAO {
	public void create(BoardVO vo, int maxGroup) throws Exception;
	public void createReply(BoardVO vo, int boardGroup, int maxSequence) throws Exception;
	public BoardVO read(int boardId) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(int boardId) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public int maxGroup() throws Exception;
	public int getGroup(int boardId) throws Exception;
	public int maxSequence(int boardGroup) throws Exception;
	public List<BoardVO> listPage(int page) throws Exception;
	public List<BoardVO> listPageHandler(PageHandler handler) throws Exception;
	public int countPaging() throws Exception;
	public List<BoardVO> listSearch(SearchPageHandler handler) throws Exception;
	public int listSearchCount(SearchPageHandler handler) throws Exception;
	public void updateCommCnt(int boardId, int amount) throws Exception;
	public void updateHit(int boardId) throws Exception;
	public void updateLike(int boardId) throws Exception;
	public void addAttach(String fullName) throws Exception;
	public List<String> getAttach(int boardId) throws Exception;
	public void deleteAttach(int boardId) throws Exception;
	public void replaceAttach(String fullName, int boardId) throws Exception;
}
