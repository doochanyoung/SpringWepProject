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

import com.java.login.LoginVO;
import com.java.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		System.out.println("login : GET");
		return "login";
	}

	@RequestMapping(value = "/login/loginCheck", method = RequestMethod.POST)
	public void loginCheck(LoginVO loginVO, HttpSession session, HttpServletResponse response) throws IOException {
		logger.info("get : /loginController");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println(loginVO.getUserId());
		System.out.println(loginVO.getUserPassword());
		PrintWriter out = response.getWriter();
		logger.info("login test1");
		System.out.println(loginVO.getUserId() + "    " + loginVO.getUserPassword());
		if ((loginVO.getUserId() != null && !loginVO.getUserId().equals("") && loginVO.getUserPassword() != null
				&& !loginVO.getUserPassword().equals(""))) {
			logger.info("login test1-1");
			if (loginService.loginCheck(loginVO)) {
				logger.info("login succece!");
				session.setAttribute("login", 0); // sdfs
				System.out.println("sdf");

				session.setAttribute("id", loginVO.getUserId());
				out.println("<script>location.href='/'); </script>");
				out.flush();
				out.close();
			}
			logger.info("login test2");
			if (loginService.loginCheck(loginVO) == false) {
				out.println("<script>alert('dsf'; history.go(-1); </script>");
				out.flush();
				out.close();
			}
			logger.info("login test3");
		}
		logger.info("login test end");
	}
}
