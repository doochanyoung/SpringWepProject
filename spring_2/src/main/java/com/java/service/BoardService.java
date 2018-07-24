package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface BoardService {
	public void regist(BoardVO vo, int maxGroup) throws Exception;
	public void registReply(BoardVO vo, int boardGroup, int maxSequence) throws Exception;
	public BoardVO read(int boardId) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public void remove(int boardId) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public int maxGroup() throws Exception;
	public int maxSequence(int boardGroup) throws Exception;
	public int getGroup(int boardId) throws Exception;
	public List<BoardVO> listPage(int page) throws Exception;
	public List<BoardVO> listPageHandler(PageHandler handler) throws Exception;
	public int countPaging() throws Exception;
	public List<BoardVO> listSearchPageHandler(SearchPageHandler handler) throws Exception;
	public int searchCountPaging(SearchPageHandler handler) throws Exception;
}
