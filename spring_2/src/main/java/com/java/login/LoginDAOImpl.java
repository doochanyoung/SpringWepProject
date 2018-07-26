package com.java.login;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Inject
	private SqlSession sql;
	
	@Override
	public boolean loginCheck(LoginVO loginVo) {
		System.out.println("now logindao");
		int count = Integer.parseInt(sql.selectOne("loginCheck", loginVo).toString()),
				totalCount = sql.selectOne("totalAccount");

		if (totalCount > 0) {
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}