package com.java.persistence;

import java.util.List;

import com.java.domain.GalleryVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

public interface GalleryDAO {
	public void create(GalleryVO vo) throws Exception;
	public GalleryVO read(int galleryId) throws Exception;
	public void update(GalleryVO vo) throws Exception;
	public void delete(int galleryId) throws Exception;
	public List<GalleryVO> listAll() throws Exception;
	public List<GalleryVO> listPage(int page) throws Exception;
	public List<GalleryVO> listPageHandler(PageHandler handler) throws Exception;
	public int countPaging() throws Exception;
	public List<GalleryVO> listSearch(SearchPageHandler handler) throws Exception;
	public int listSearchCount(SearchPageHandler handler) throws Exception;
	public void updateCommCnt(int galleryId, int amount) throws Exception;
	public void updateHit(int galleryId) throws Exception;
	public void updateLike(int galleryId) throws Exception;
	public void addAttach(String fullName) throws Exception;
	public List<String> getAttach(int galleryId) throws Exception;
	public void deleteAttach(int galleryId) throws Exception;
	public void replaceAttach(String fullName, int galleryId) throws Exception;
}
