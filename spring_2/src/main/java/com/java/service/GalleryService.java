package com.java.service;

import java.util.List;

import com.java.domain.BoardVO;
import com.java.domain.GalleryVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface GalleryService {
	public void regist(GalleryVO vo) throws Exception;
	public GalleryVO read(int galleryId) throws Exception;
	public void modify(GalleryVO vo) throws Exception;
	public void remove(int galleryId) throws Exception;
	public List<GalleryVO> listAll() throws Exception;
	public List<GalleryVO> listPage(int page) throws Exception;
	public List<GalleryVO> listPageHandler(PageHandler handler) throws Exception;
	public int countPaging() throws Exception;
	public List<GalleryVO> listSearchPageHandler(SearchPageHandler handler) throws Exception;
	public int searchCountPaging(SearchPageHandler handler) throws Exception;
	public void updateHit(int galleryId) throws Exception;
	public void updateLike(int galleryId) throws Exception;
	public List<String> getAttach(int galleryId) throws Exception;
}
