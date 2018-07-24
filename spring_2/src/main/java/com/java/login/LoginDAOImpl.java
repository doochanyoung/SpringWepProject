package com.java.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO {
	private SqlSession sql;
	
	public boolean loginCheck(LoginVO loginInfo) {
		int count = Integer.parseInt(sql.selectOne("loginCheck", loginInfo).toString()),
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