package com.java.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.domain.UserVO;
import com.java.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Inject
	private UserDAO userdao;

	@Override
	public UserVO getUser(String userId) {
		return userdao.getUser(userId);
	}

	@Override
	public void userModify(UserVO vo) {
		userdao.userModify(vo);
	}

}
