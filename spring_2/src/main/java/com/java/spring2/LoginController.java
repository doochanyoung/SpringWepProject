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

import com.java.login.LoginVo;
import com.java.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	LoginService loginDAO;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		System.out.println("login : GET");
		return "login";
	}
	
	@RequestMapping(value="/login/loginCheck", method = RequestMethod.POST)
	public void loginCheck( LoginVo loginVo, HttpSession session, HttpServletResponse response) throws IOException{
		logger.info("get : /loginController");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();

		logger.info("login test1");
		System.out.println(loginVo.getId()+ "    " +  loginVo.getPassword());
		if((loginVo.getId() != null && !loginVo.getId().equals("") 
				&& loginVo.getPassword() != null && !loginVo.getPassword().equals(""))) {
			logger.info("login test1-1");
			if ( loginDAO.loginCheck(loginVo)) {
				logger.info("login succece!");
				session.setAttribute("login", 0); //sdfs
				System.out.println("sdf");
				
				session.setAttribute("id", loginVo.getId());
				
				out.println("<script>location.href='/'); </script>");
				out.flush();
				out.close();
			}
			logger.info("login test2");
			if (loginDAO.loginCheck(loginVo) == false) {
				out.println("<script>alert('dsf'; history.go(-1); </script>");
				out.flush();
				out.close();
			}
			logger.info("login test3");
		}
		logger.info("login test end");
	}
}
