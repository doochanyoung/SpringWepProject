package com.java.login;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	
	@Inject
	private SqlSession sql;
	
	private static String namespace = "com.java.mapper.loginMapper";
	
	@Override
	public boolean loginCheck(LoginVO loginVo) {
		int count = Integer.parseInt(sql.selectOne(namespace+".loginCheck", loginVo).toString());
		int	totalCount = sql.selectOne("totalAccount");
		System.out.println(count);
		System.out.println(count);
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