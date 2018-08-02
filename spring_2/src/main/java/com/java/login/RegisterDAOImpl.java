package com.java.login;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAOImpl implements RegisterDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.java.mapper.registerMapper";
	
	@Override
	public boolean registerCheck(LoginVO loginVo) {
		int count = Integer.parseInt(sql.selectOne(namespace+".registerCheck", loginVo).toString());

		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void register(LoginVO loginVo) {
		sql.selectOne(namespace+".register", loginVo);
	}
}