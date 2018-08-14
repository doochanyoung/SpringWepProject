package com.java.service;

import com.java.domain.UserVO;

public interface UserService {
	public UserVO getUser(String userId);
	public void userModify(UserVO vo);
}
