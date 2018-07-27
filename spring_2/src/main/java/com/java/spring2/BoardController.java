package com.java.spring2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.java.domain.PageMaker;
import com.java.domain.SearchPageHandler;
import com.java.service.BoardService;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/board/*")
public class BoardController {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public void board(@ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardList");
		model.addAttribute("list", service.listSearchPageHandler(pageHandler));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageHandler(pageHandler);
		logger.info(pageHandler.toString());
		pageMaker.setTotalCount(service.searchCountPaging(pageHandler));
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/boardRead", method = RequestMethod.GET)
	public String boardReadGET(@RequestParam("boardId") int boardId, @ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("get : /boardRead");
		Cookie cookies[] = request.getCookies();
		Map<String, String> mapCookie = new HashMap<String, String>();
		if(request.getCookies() != null) {
			for(int i = 0; i < cookies.length; i++) {
				Cookie obj = cookies[i];
				System.out.println(obj.getName() + " " + obj.getValue());
				mapCookie.put(obj.getName(), obj.getValue());
			}
		}
		String cookieReadCount = (String) mapCookie.get("readCount");
		System.out.println(cookieReadCount);
		String newCookieReadCount = "|" + boardId;
		if(StringUtils.indexOfIgnoreCase(cookieReadCount, newCookieReadCount) == -1) {
			Cookie cookie = new Cookie("readCount", cookieReadCount + newCookieReadCount);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
			service.updateHit(boardId);
		}
		model.addAttribute("boardVO", service.read(boardId));
		return "/board/boardRead";
	}
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	public String boardDelete(@RequestParam("boardId") int boardId, SearchPageHandler pageHandler, RedirectAttributes rttr) throws Exception {
		logger.info("get : /boardDelete");
		service.remove(boardId);
		rttr.addAttribute("page", pageHandler.getPage());
		rttr.addAttribute("perPageNum", pageHandler.getPerPageNum());
		rttr.addAttribute("searchType", pageHandler.getSearchType());
		rttr.addAttribute("keyword", pageHandler.getKeyword());
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.GET)
	public void boardModifyGET(int boardId, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardModify");
		model.addAttribute("boardVO", service.read(boardId));
		model.addAttribute("pageHandler", pageHandler);
	}
	
	@RequestMapping(value = "/boardModify", method = RequestMethod.POST)
	public String boardModifyPOST(BoardVO vo, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardModify");
		service.modify(vo);
		return "redirect:/board/boardRead?boardId=" + vo.getBoardId() +"&page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum()
		 + "&searchType=" + pageHandler.getSearchType() + "&keyword=" + pageHandler.getKeyword();
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
	public void boardReplyGET(int boardId, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /boardReply");
		model.addAttribute("boardId", boardId);
		model.addAttribute("pageHandler", pageHandler);
	}
	
	@RequestMapping(value = "/boardReply", method = RequestMethod.POST)
	public String boardReplyPOST(BoardVO board, SearchPageHandler pageHandler, Model model) throws Exception {
		System.out.println(board);
		logger.info("post : /boardReply");
		int boardGroup = service.getGroup(board.getBoardId());
		int maxSequence = service.maxSequence(boardGroup);
		service.registReply(board, boardGroup, maxSequence);
		return "redirect:/board/boardList?page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum()
		+ "&searchType=" + pageHandler.getSearchType() + "&keyword=" + pageHandler.getKeyword();
	}
	
}