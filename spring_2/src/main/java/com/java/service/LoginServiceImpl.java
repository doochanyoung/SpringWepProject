package com.java.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.login.LoginDAO;
import com.java.login.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Inject
	private LoginDAO dao;

	@Override
	public boolean loginCheck(LoginVO loginVo) {
		return dao.loginCheck(loginVo);
	}
}
