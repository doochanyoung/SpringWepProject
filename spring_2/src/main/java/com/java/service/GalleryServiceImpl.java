package com.java.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.domain.GalleryVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;
import com.java.persistence.GalleryDAO;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Inject
	private GalleryDAO galleryDao;
	
	@Transactional
	@Override
	public void regist(GalleryVO vo) throws Exception {
		galleryDao.create(vo);
		String[] files = vo.getFiles();
		if(files == null) {return;}
		for(String fileName : files) {
			galleryDao.addAttach(fileName);
		}
	}

	@Override
	public GalleryVO read(int galleryId) throws Exception {
		return galleryDao.read(galleryId);
	}

	@Transactional
	@Override
	public void modify(GalleryVO vo) throws Exception {
		galleryDao.update(vo);
		int galleryId = vo.getGalleryId();
		galleryDao.deleteAttach(galleryId);
		String[] files = vo.getFiles();
		if(files == null) {return;}
		for(String fileName : files) {
			galleryDao.replaceAttach(fileName, galleryId);
		}
	}

	@Transactional
	@Override
	public void remove(int galleryId) throws Exception {
		galleryDao.deleteAttach(galleryId);
		galleryDao.delete(galleryId);
	}

	@Override
	public List<GalleryVO> listAll() throws Exception {
		return galleryDao.listAll();
	}

	@Override
	public List<GalleryVO> listPage(int page) throws Exception {
		return galleryDao.listPage(page);
	}

	@Override
	public List<GalleryVO> listPageHandler(PageHandler handler) throws Exception {
		return galleryDao.listPageHandler(handler);
	}

	@Override
	public int countPaging() throws Exception {
		return galleryDao.countPaging();
	}

	@Override
	public List<GalleryVO> listSearchPageHandler(SearchPageHandler handler) throws Exception {
		return galleryDao.listSearch(handler);
	}

	@Override
	public int searchCountPaging(SearchPageHandler handler) throws Exception {
		return galleryDao.listSearchCount(handler);
	}
	

	@Override
	public void updateHit(int galleryId) throws Exception {
		galleryDao.updateHit(galleryId);
	}

	@Override
	public void updateLike(int galleryId) throws Exception {
		galleryDao.updateLike(galleryId);
	}

	@Override
	public List<String> getAttach(int galleryId) throws Exception {
		return galleryDao.getAttach(galleryId);
	}

}
