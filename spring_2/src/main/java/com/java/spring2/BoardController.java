package com.java.spring2;

import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.domain.BoardVO;
import com.java.domain.PageHandler;
import com.java.domain.PageMaker;
import com.java.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void board(PageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardList");
		logger.info(pageHandler.toString());
		model.addAttribute("list", service.listPageHandler(pageHandler));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageHandler(pageHandler);
		pageMaker.setTotalCount(service.countPaging());
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public void boardReadGET(@RequestParam("boardId") int boardId, @ModelAttribute("pageHandler") PageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardRead");
		model.addAttribute("boardVO", service.read(boardId));
	}
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(@RequestParam("boardId") int boardId, PageHandler pageHandler, RedirectAttributes rttr) throws Exception {
		logger.info("get : /boardDelete");
		service.remove(boardId);
		rttr.addAttribute("page", pageHandler.getPage());
		rttr.addAttribute("perPageNum", pageHandler.getPerPageNum());
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public void boardModifyGET(int boardId, PageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardModify");
		model.addAttribute("boardVO", service.read(boardId));
		model.addAttribute("page", pageHandler.getPage());
		model.addAttribute("perPageNum", pageHandler.getPerPageNum());
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModifyPOST(BoardVO vo, PageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardModify");
		service.modify(vo);
		return "redirect:/board/boardRead?boardId=" + vo.getBoardId() +"&page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum();
	}
	
	@RequestMapping(value = "/boardWrite", method = RequestMethod.GET)
	public void boardWriteGET(Locale locale, Model model) {
		logger.info("get : /boardWrite");
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
	
	@RequestMapping(value = "/boardReply", method = RequestMethod.GET)
	public void boardReplyGET(int boardId, PageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardReply");
		model.addAttribute("boardId", boardId);
		model.addAttribute("page", pageHandler.getPage());
		model.addAttribute("perPageNum", pageHandler.getPerPageNum());
	}
	
	@RequestMapping(value = "/boardReply", method = RequestMethod.POST)
	public String boardReplyPOST(BoardVO board, PageHandler pageHandler, Model model) throws Exception {
		System.out.println(board);
		logger.info("post : /boardReply");
		int boardGroup = service.getGroup(board.getBoardId());
		int maxSequence = service.maxSequence(boardGroup);
		service.registReply(board, boardGroup, maxSequence);
		return "redirect:/board/boardList?page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum();
	}
	
}