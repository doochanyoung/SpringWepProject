package com.java.spring2;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.domain.BoardVO;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public String board(Locale locale, Model model) {
		logger.info("get : /boardList");
		return "board/boardList";
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public String boardWriteGET(Locale locale, Model model) {
		logger.info("get : /boardWrite");
		return "board/boardWrite";
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWritePOST(BoardVO board, Model model) throws Exception {
		logger.info("post : /boardWrite");
		logger.info(board.toString());
		service.regist(board);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/dataroomList", method = RequestMethod.GET)
	public String dataroomList(Locale locale, Model model) {
		logger.info("get : /dataroomList");
		return "board/dataroomList";
	}
	
}