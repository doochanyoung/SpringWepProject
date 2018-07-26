package com.java.spring2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.login.LoginDAO;
import com.java.login.LoginVO;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private LoginDAO loginDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		System.out.println("login : GET");
		return "login";
	}
	
	@RequestMapping(value="/login/loginCheck", method = RequestMethod.POST)
	public void loginCheck(LoginVO loginInfo, HttpSession session, HttpServletResponse response) throws IOException{
		logger.info("get : /loginController");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(loginInfo.getUserId());
		System.out.println(loginInfo.getUserPassword());
		PrintWriter out=response.getWriter();
		
		if((loginInfo.getUserId() != null && !loginInfo.getUserId().equals("") 
				&& loginInfo.getUserPassword() != null && !loginInfo.getUserPassword().equals(""))) {
			if ( loginDAO.loginCheck(loginInfo)) {
				logger.info("login succece!");
				session.setAttribute("login", 0); //sdfs
				System.out.println("sdf");
				
				session.setAttribute("id", loginInfo.getUserId());
				
				out.println("<script>location.href='/'); </script>");
				out.flush();
				out.close();
			}
			if (loginDAO.loginCheck(loginInfo) == false) {
				out.println("<script>alert('dsf'; history.go(-1); </script>");
				out.flush();
				out.close();
			}
		}
	}
}
