package com.java.service;

import com.java.login.LoginVO;

public interface RegisterService {
	public boolean registerCheck(LoginVO loginVo);
	public void register(LoginVO loginVo);
}
