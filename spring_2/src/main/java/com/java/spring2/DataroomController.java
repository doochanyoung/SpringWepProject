package com.java.spring2;

import java.util.HashMap;
import java.util.List;
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

import com.java.domain.DataroomVO;
import com.java.domain.PageMaker;
import com.java.domain.SearchPageHandler;
import com.java.service.DataroomService;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/dataroom/*")
public class DataroomController {
private static final Logger logger = LoggerFactory.getLogger(DataroomController.class);

	@Inject
	private DataroomService service;
	
	@RequestMapping(value = "/dataroomList", method = RequestMethod.GET)
	public void dataroom(@ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /dataroomList");
		model.addAttribute("list", service.listSearchPageHandler(pageHandler));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageHandler(pageHandler);
		logger.info(pageHandler.toString());
		pageMaker.setTotalCount(service.searchCountPaging(pageHandler));
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/dataroomRead", method = RequestMethod.GET)
	public String dataroomReadGET(@RequestParam("dataroomId") int dataroomId, @ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("get : /dataroomRead");
		Cookie cookies[] = request.getCookies();
		Map<String, String> mapCookie = new HashMap<String, String>();
		if(request.getCookies() != null) {
			for(int i = 0; i < cookies.length; i++) {
				Cookie obj = cookies[i];
				System.out.println(obj.getName() + " " + obj.getValue());
				mapCookie.put(obj.getName(), obj.getValue());
			}
		}
		String cookieReadCount = (String) mapCookie.get("readCount2");
		System.out.println(cookieReadCount);
		String newCookieReadCount = "|" + dataroomId;
		if(StringUtils.indexOfIgnoreCase(cookieReadCount, newCookieReadCount) == -1) {
			Cookie cookie = new Cookie("readCount2", cookieReadCount + newCookieReadCount);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
			service.updateHit(dataroomId);
		}
		model.addAttribute("dataroomVO", service.read(dataroomId));
		System.out.println("¾¾¹ß = " +service.read(dataroomId));
		return "/dataroom/dataroomRead";
	}
	
	@RequestMapping(value = "/dataroomDelete", method = RequestMethod.POST)
	public String dataroomDelete(@RequestParam("dataroomId") int dataroomId, SearchPageHandler pageHandler, RedirectAttributes rttr) throws Exception {
		logger.info("get : /dataroomDelete");
		service.remove(dataroomId);
		rttr.addAttribute("page", pageHandler.getPage());
		rttr.addAttribute("perPageNum", pageHandler.getPerPageNum());
		rttr.addAttribute("searchType", pageHandler.getSearchType());
		rttr.addAttribute("keyword", pageHandler.getKeyword());
		return "redirect:/dataroom/dataroomList";
	}
	
	@RequestMapping(value = "/dataroomModify", method = RequestMethod.GET)
	public void dataroomModifyGET(int dataroomId, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /dataroomModify");
		model.addAttribute("dataroomVO", service.read(dataroomId));
		model.addAttribute("pageHandler", pageHandler);
	}
	
	@RequestMapping(value = "/dataroomModify", method = RequestMethod.POST)
	public String dataroomModifyPOST(DataroomVO vo, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /dataroomModify");
		service.modify(vo);
		return "redirect:/dataroom/dataroomRead?dataroomId=" + vo.getDataroomId() +"&page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum()
		 + "&searchType=" + pageHandler.getSearchType() + "&keyword=" + pageHandler.getKeyword();
	}
	
	@RequestMapping(value = "/dataroomWrite", method = RequestMethod.GET)
	public void dataroomWriteGET(Locale locale, Model model) {
		logger.info("get : /dataroomWrite");
	}
	
	@RequestMapping(value = "/dataroomWrite", method = RequestMethod.POST)
	public String dataroomWritePOST(DataroomVO dataroom, Model model) throws Exception {
		logger.info("post : /dataroomWrite");
		logger.info(dataroom.toString());
		dataroom.setDataroomTitle(dataroom.getDataroomTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
		dataroom.setDataroomContent(dataroom.getDataroomContent().replaceAll("\n", "<br>"));
		int maxGroup = Math.max(service.maxGroup(), 0);
		logger.info("maxGroup : " + maxGroup);
		service.regist(dataroom, maxGroup);
		return "redirect:/dataroom/dataroomList";
	}

	@RequestMapping(value = "/dataroomReply", method = RequestMethod.GET)
	public void dataroomReplyGET(int dataroomId, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /dataroomReply");
		model.addAttribute("dataroomId", dataroomId);
		model.addAttribute("pageHandler", pageHandler);
	}
	
	@RequestMapping(value = "/dataroomReply", method = RequestMethod.POST)
	public String dataroomReplyPOST(DataroomVO dataroom, SearchPageHandler pageHandler, Model model) throws Exception {
		System.out.println(dataroom);
		logger.info("post : /dataroomReply");
		int dataroomGroup = service.getGroup(dataroom.getDataroomId());
		int maxSequence = service.maxSequence(dataroomGroup);
		service.registReply(dataroom, dataroomGroup, maxSequence);
		return "redirect:/dataroom/dataroomList?page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum()
		+ "&searchType=" + pageHandler.getSearchType() + "&keyword=" + pageHandler.getKeyword();
	}
	
}