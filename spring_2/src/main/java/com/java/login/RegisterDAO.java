package com.java.login;

public interface RegisterDAO {
	public boolean registerCheck(LoginVO loginVo);
	public void register(LoginVO loginVo);
}