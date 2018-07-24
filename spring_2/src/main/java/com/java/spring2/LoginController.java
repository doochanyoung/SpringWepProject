package com.java.spring2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.login.LoginDAO;
import com.java.login.LoginVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private LoginDAO loginDAO;
	
	@RequestMapping(value="/login/loginCheck")
	public void loginCheck( LoginVO loginInfo, HttpSession session, HttpServletResponse response) throws IOException{
		logger.info("get : /loginController");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if((loginInfo.getId() != null && !loginInfo.getId().equals("") 
				&& loginInfo.getPassword() != null && !loginInfo.getPassword().equals(""))) {
			if ( loginDAO.loginCheck(loginInfo)) {
				logger.info("login succece!");
				session.setAttribute("login", 0); //로그인 성공 세션
				System.out.println("세션 추가됨");
				
				session.setAttribute("id", loginInfo.getId());
				
				out.println("<script>location.href='/'); </script>");
				out.flush();
				out.close();
			}
			if (loginDAO.loginCheck(loginInfo) == false) {
				out.println("<script>alert('로그인 정보를 확인하세요!'; history.go(-1); </script>");
				out.flush();
				out.close();
			}
		}
	}
}
