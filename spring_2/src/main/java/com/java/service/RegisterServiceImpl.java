package com.java.service;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.java.login.LoginVO;
import com.java.login.RegisterDAO;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Inject
	private RegisterDAO dao;

	@Override
	public boolean registerCheck(LoginVO loginVo){
		return dao.registerCheck(loginVo);
	}

	@Override
	public void register(LoginVO loginVo){
		dao.register(loginVo);
	}
}
