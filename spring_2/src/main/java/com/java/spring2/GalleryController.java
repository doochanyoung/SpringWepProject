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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java.domain.GalleryVO;
import com.java.domain.PageMaker;
import com.java.domain.SearchPageHandler;
import com.java.service.GalleryService;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/gallery/*")
public class GalleryController {
private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);

	@Inject
	private GalleryService service;
	
	@RequestMapping(value = "/galleryList", method = RequestMethod.GET)
	public void gallery(@ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /galleryList");
		model.addAttribute("list", service.listSearchPageHandler(pageHandler));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageHandler(pageHandler);
		logger.info(pageHandler.toString());
		pageMaker.setTotalCount(service.searchCountPaging(pageHandler));
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@RequestMapping(value = "/galleryRead", method = RequestMethod.GET)
	public String galleryReadGET(@RequestParam("galleryId") int galleryId, @ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model, HttpServletResponse response, HttpServletRequest request) throws Exception {
		logger.info("get : /galleryRead");
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
		String newCookieReadCount = "|" + galleryId;
		if(StringUtils.indexOfIgnoreCase(cookieReadCount, newCookieReadCount) == -1) {
			Cookie cookie = new Cookie("readCount2", cookieReadCount + newCookieReadCount);
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
			service.updateHit(galleryId);
		}
		model.addAttribute("galleryVO", service.read(galleryId));
		System.out.println("���� = " +service.read(galleryId));
		return "/gallery/galleryRead";
	}
	
	@RequestMapping(value = "/galleryDelete", method = RequestMethod.POST)
	public String galleryDelete(@RequestParam("galleryId") int galleryId, SearchPageHandler pageHandler, RedirectAttributes rttr) throws Exception {
		logger.info("get : /galleryDelete");
		service.remove(galleryId);
		rttr.addAttribute("page", pageHandler.getPage());
		rttr.addAttribute("perPageNum", pageHandler.getPerPageNum());
		rttr.addAttribute("searchType", pageHandler.getSearchType());
		rttr.addAttribute("keyword", pageHandler.getKeyword());
		return "redirect:/gallery/galleryList";
	}
	
	@RequestMapping(value = "/galleryModify", method = RequestMethod.GET)
	public void galleryModifyGET(int galleryId, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /galleryModify");
		model.addAttribute("galleryVO", service.read(galleryId));
		model.addAttribute("pageHandler", pageHandler);
	}
	
	@RequestMapping(value = "/galleryModify", method = RequestMethod.POST)
	public String galleryModifyPOST(GalleryVO vo, SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /galleryModify");
		service.modify(vo);
		return "redirect:/gallery/galleryRead?galleryId=" + vo.getGalleryId() +"&page=" + pageHandler.getPage() + "&perPageNum=" + pageHandler.getPerPageNum()
		 + "&searchType=" + pageHandler.getSearchType() + "&keyword=" + pageHandler.getKeyword();
	}
	
	@RequestMapping(value = "/galleryWrite", method = RequestMethod.GET)
	public void galleryWriteGET(Locale locale, Model model) {
		logger.info("get : /galleryWrite");
	}
	
	@RequestMapping(value = "/galleryWrite", method = RequestMethod.POST)
	public String galleryWritePOST(GalleryVO gallery, Model model) throws Exception {
		logger.info("post : /galleryWrite");
		logger.info(gallery.toString());
		gallery.setGalleryTitle(gallery.getGalleryTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
		service.regist(gallery);
		return "redirect:/gallery/galleryList";
	}

	@ResponseBody
	@RequestMapping("/getAttach/{galleryId}")
	public List<String> getAttach(@PathVariable("galleryId") int galleryId) throws Exception{
		logger.info("/getAttach/" + galleryId);
		return service.getAttach(galleryId);
	}
}