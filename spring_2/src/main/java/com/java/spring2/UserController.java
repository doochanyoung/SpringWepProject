package com.java.spring2;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.domain.UserVO;
import com.java.service.UserService;

@Controller
@RequestMapping(value = "/user/*")
public class UserController {
	
	@Inject
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/userModify", method = RequestMethod.GET)
	public void userModifyGET(Model model, HttpSession session) {
		logger.info("userModify : GET");
		System.out.println(session.getAttribute("loginId"));
		model.addAttribute("userVO", userService.getUser((String)session.getAttribute("loginId")));
	}
	

	@RequestMapping(value = "/userModify", method = RequestMethod.POST)
	public String userModifyPOST(Model model, HttpSession session, UserVO vo) {
		logger.info("userModify : POST");
		userService.userModify(vo);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public void userProfileGET(Model model, HttpSession session) {
		logger.info("userModify : GET");
	}
	
	@RequestMapping(value = "/messageList", method = RequestMethod.GET)
	public void messageListGET(Model model, HttpSession session) {
		logger.info("userModify : GET");
	}
	
	
	
}
