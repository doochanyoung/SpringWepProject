package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.GalleryVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

@Repository
public class GalleryDAOImpl implements GalleryDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.GalleryMapper"; 

	@Override
	public void create(GalleryVO vo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getGalleryTitle());
		paramMap.put("userId", vo.getGalleryUserId());
		paramMap.put("attachName", vo.getGalleryAttachName());
		session.insert(namespace + ".create", paramMap);
	}

	@Override
	public GalleryVO read(int galleryId) throws Exception {
		return session.selectOne(namespace + ".read", galleryId);
	}

	@Override
	public void update(GalleryVO vo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getGalleryTitle());
		paramMap.put("galleryId", vo.getGalleryId());
		paramMap.put("attachName", vo.getGalleryAttachName());
		session.update(namespace + ".update", paramMap);
	}

	@Override
	public void delete(int galleryId) throws Exception {
		session.delete(namespace + ".delete", galleryId);
	}

	@Override
	public List<GalleryVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}
	
	@Override
	public List<GalleryVO> listPage(int page) throws Exception {
		if(page <= 0) page = 1;
		page = (page - 1) * 30;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<GalleryVO> listPageHandler(PageHandler handler) throws Exception {
		return session.selectList(namespace + ".listPageHandler", handler);
	}

	@Override
	public int countPaging() throws Exception {
		return session.selectOne(namespace + ".countPaging");
	}

	@Override
	public List<GalleryVO> listSearch(SearchPageHandler handler) throws Exception {
		return session.selectList(namespace + ".listSearch", handler);
	}

	@Override
	public int listSearchCount(SearchPageHandler handler) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", handler);
	}
	
	@Override
	public void updateCommCnt(int galleryId, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("galleryId", galleryId);
		paramMap.put("amount", amount);
		session.update(namespace + ".updateCommCnt", paramMap);
	}
	
	@Override
	public void updateHit(int galleryId) throws Exception {
		session.update(namespace + ".updateHit", galleryId);
	}

	@Override
	public void updateLike(int galleryId) throws Exception {
		session.update(namespace + ".updateLike", galleryId);
	}

	@Override
	public void addAttach(String fullName) throws Exception {
		session.insert(namespace + ".addAttach", fullName);
	}

	@Override
	public List<String> getAttach(int galleryId) throws Exception {
		return session.selectList(namespace + ".getAttach", galleryId);
	}

	@Override
	public void deleteAttach(int galleryId) throws Exception {
		session.delete(namespace + ".deleteAttach", galleryId);
	}

	@Override
	public void replaceAttach(String fullName, int galleryId) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("galleryId", galleryId);
		paramMap.put("fullName", fullName);
		session.update(namespace + ".replaceAttach", paramMap);
	}


}
