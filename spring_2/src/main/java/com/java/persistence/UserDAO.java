package com.java.persistence;

import com.java.domain.UserVO;

public interface UserDAO {
	public UserVO getUser(String userId);
	public void userModify(UserVO vo);
}
