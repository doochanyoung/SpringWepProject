package com.java.spring2;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.domain.BoardVO;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void board(Locale locale, Model model) throws Exception {
		logger.info("get : /boardList");
		model.addAttribute("list", service.listAll());
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public void boardWriteGET(Locale locale, Model model) {
		logger.info("get : /boardWrite");
	}
	
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public void boardReadGET(@RequestParam("boardId") int boardId, Model model) throws Exception {
		logger.info("get : /boardRead");
		model.addAttribute("boardVO", service.read(boardId));
	}
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(@RequestParam("boardId") int boardId, Model model) throws Exception {
		logger.info("get : /boardDelete");
		service.remove(boardId);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public void boardModifyGET(int boardId, Model model) throws Exception {
		logger.info("get : /boardModify");
		model.addAttribute("boardVO", service.read(boardId));
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModifyPOST(BoardVO vo, Model model) throws Exception {
		logger.info("get : /boardModify");
		service.modify(vo);
		return "redirect:/board/boardRead?boardId=" + vo.getBoardId();
	}
	
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.POST)
	public String boardWritePOST(BoardVO board, Model model) throws Exception {
		logger.info("post : /boardWrite");
		logger.info(board.toString());
		board.setBoardTitle(board.getBoardTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
		board.setBoardContent(board.getBoardContent().replaceAll("\n", "<br>"));
		int maxGroup = Math.max(service.maxGroup(), 0);
		logger.info("maxGroup : " + maxGroup);
		service.regist(board, maxGroup);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/dataroomList", method = RequestMethod.GET)
	public void dataroomList(Locale locale, Model model) {
		logger.info("get : /dataroomList");
	}
	
}