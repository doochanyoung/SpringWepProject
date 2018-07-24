package com.java.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.login.LoginVO;
import com.java.login.LoginDAO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Inject
	private LoginDAO dao;

	@Override
	public boolean loginCheck(LoginVO loginVo) throws Exception {
		boolean flag;
		return flag = loginCheck(loginVo);
	}
}
