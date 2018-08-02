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
import com.java.service.RegisterService;

@Controller
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private RegisterService registerService;
	
	@RequestMapping(value="/registerCheck")
	public ModelAndView homeView(ModelAndView mv)
	{
		logger.info("ModelAndView");
		String page = "registerCheck";
		mv.setViewName(page);
		
		return mv;
	}
	
	@RequestMapping(value="/login/registerCheck")
	public void registerCheck(Locale locale, Model model, LoginVO regiInfo, HttpSession session, HttpServletResponse response) throws IOException{
		logger.info("get : /registerCheck");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		if((regiInfo.getUserId() != null && !regiInfo.getUserId().equals("") 
				&& regiInfo.getUserPassword() != null && !regiInfo.getUserPassword().equals(""))) {

			if ( registerService.registerCheck(regiInfo)) {
				
				logger.info("중복아이디 없음!", locale);
				
				registerService.register(regiInfo);
				
				out.println("<script>location.href='/registerCheck'; </script>");
				out.flush();
				out.close();
			}
			if ( registerService.registerCheck(regiInfo) == false) {
				out.println("<script>alert('이미 사용중인 아이디입니다.!'); history.go(-1); </script>");
				out.flush();
				out.close();
			}
		}
	}
}
