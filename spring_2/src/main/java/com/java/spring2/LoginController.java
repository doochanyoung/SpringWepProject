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
import org.springframework.web.servlet.ModelAndView;

import com.java.login.LoginVO;
import com.java.service.LoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private LoginService loginService;
	
	@RequestMapping(value="/home")
	public ModelAndView homeView(ModelAndView mv)
	{
		logger.info("ModelAndView");
		String page = "home";
		mv.setViewName(page);
		
		return mv;
	}
	
	@RequestMapping(value="/login/loginCheck")
	public void loginCheck(Locale locale, Model model, LoginVO loginInfo, HttpSession session, HttpServletResponse response) throws IOException{
		logger.info("get : /loginCheck");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if((loginInfo.getUserId() != null && !loginInfo.getUserId().equals("") 
				&& loginInfo.getUserPassword() != null && !loginInfo.getUserPassword().equals(""))) {

			if ( loginService.loginCheck(loginInfo)) {
				session.setAttribute("loginId", loginInfo.getUserId()); //로그인 성공 세션
				
				logger.info("로그인이 정상적으로 완료되었습니다.", locale);
				
				out.println("<script>location.href='/home'; </script>");
				out.flush();
				out.close();
			}
			if ( loginService.loginCheck(loginInfo) == false) {
				System.out.println("로그인 실패");
				out.println("<script>alert('로그인 정보를 확인하세요!'); history.go(-1); </script>");
				out.flush();
				out.close();
			}
		}
	}
	
	@RequestMapping(value="/login/logout")
	public ModelAndView logOut(ModelAndView mv, HttpSession session) {
		String page = "redirect:/home";
		session.removeAttribute("loginId");
		mv.setViewName(page);
		return mv;
	}
}
