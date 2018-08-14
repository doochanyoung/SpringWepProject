package com.java.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.java.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	private SqlSession session;
	
	private static String namespace = "com.java.mapper.UserMapper"; 

	@Override
	public UserVO getUser(String userId) {
		return session.selectOne(namespace + ".getUser", userId);
	}

	@Override
	public void userModify(UserVO vo) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", vo.getUserId());
		paramMap.put("userName", vo.getUserName());
		paramMap.put("userNickname", vo.getUserNickname());
		paramMap.put("userPassword", vo.getUserPassword());
		paramMap.put("userEmail", vo.getUserEmail());
		paramMap.put("userPhone", vo.getUserPhone());
		paramMap.put("userIntro", vo.getUserIntro());
		session.update(namespace + ".modify", paramMap);
	}

}
