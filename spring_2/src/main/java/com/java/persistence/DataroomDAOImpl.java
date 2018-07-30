package com.java.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.BoardVO;
import com.java.domain.DataroomVO;
import com.java.domain.PageHandler;
import com.java.domain.SearchPageHandler;

@Repository
public class DataroomDAOImpl implements DataroomDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.DataroomMapper"; 

	@Override
	public void create(DataroomVO vo, int maxGroup) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getDataroomTitle());
		paramMap.put("content", vo.getDataroomContent());
		paramMap.put("userId", vo.getDataroomUserId());
		paramMap.put("maxGroup", maxGroup + 1);
		session.insert(namespace + ".create", paramMap);
	}

	@Override
	public void createReply(DataroomVO vo, int dataroomGroup, int maxSequence) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getDataroomTitle());
		paramMap.put("content", vo.getDataroomContent());
		paramMap.put("userId", vo.getDataroomUserId());
		paramMap.put("group", dataroomGroup);
		paramMap.put("sequence", maxSequence + 1);
		session.insert(namespace + ".createReply", paramMap);
	}

	@Override
	public DataroomVO read(int dataroomId) throws Exception {
		return session.selectOne(namespace + ".read", dataroomId);
	}

	@Override
	public void update(DataroomVO vo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("title", vo.getDataroomTitle());
		paramMap.put("content", vo.getDataroomContent());
		paramMap.put("dataroomId", vo.getDataroomId());
		session.update(namespace + ".update", paramMap);
	}

	@Override
	public void delete(int dataroomId) throws Exception {
		session.delete(namespace + ".delete", dataroomId);
	}

	@Override
	public List<DataroomVO> listAll() throws Exception {
		return session.selectList(namespace + ".listAll");
	}

	@Override
	public int maxGroup() throws Exception {
		if(countPaging() == 0) {
			return 0;
		}
		return session.selectOne(namespace + ".maxGroup");
	}

	@Override
	public int getGroup(int dataroomId) throws Exception {
		return session.selectOne(namespace + ".getGroup", dataroomId);
	}

	@Override
	public int maxSequence(int dataroomGroup) throws Exception {
		return session.selectOne(namespace + ".maxSequence", dataroomGroup);
	}

	@Override
	public List<DataroomVO> listPage(int page) throws Exception {
		if(page <= 0) page = 1;
		page = (page - 1) * 30;
		return session.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<DataroomVO> listPageHandler(PageHandler handler) throws Exception {
		return session.selectList(namespace + ".listPageHandler", handler);
	}

	@Override
	public int countPaging() throws Exception {
		return session.selectOne(namespace + ".countPaging");
	}

	@Override
	public List<DataroomVO> listSearch(SearchPageHandler handler) throws Exception {
		return session.selectList(namespace + ".listSearch", handler);
	}

	@Override
	public int listSearchCount(SearchPageHandler handler) throws Exception {
		return session.selectOne(namespace + ".listSearchCount", handler);
	}
	
	@Override
	public void updateCommCnt(int dataroomId, int amount) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("dataroomId", dataroomId);
		paramMap.put("amount", amount);
		session.update(namespace + ".updateCommCnt", paramMap);
	}
	
	@Override
	public void updateHit(int dataroomId) throws Exception {
		session.update(namespace + ".updateHit", dataroomId);
	}

	@Override
	public void updateLike(int dataroomId) throws Exception {
		session.update(namespace + ".updateLike", dataroomId);
	}


}
