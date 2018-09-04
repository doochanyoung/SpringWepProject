package com.java.spring2;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.domain.MessageVO;
import com.java.domain.PageMaker;
import com.java.domain.SearchPageHandler;
import com.java.service.MessageService;

@Controller
public class MessageController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Inject
    MessageService service;
    // ResponseEntity    : HTTP상태코드 + 데이터  전달
    // @RequestBody        : 클라이언트 => 서버 (json 데이터가 입력될 때)
    // @ResponsetBody    : 서버 => 클라이언트 (json) RestController에서는 생략가능
    
    @RequestMapping(value="/addMessage", method=RequestMethod.POST)
    public ResponseEntity<String> addMessage(@RequestBody MessageVO vo){
        ResponseEntity<String> entity = null;
        logger.info("messageController");
        try {
            service.addMessage(vo);
            // new ResponseEntity<자료형>(리턴값, HTTP상태코드);
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
    
    @RequestMapping(value = "/messageList", method = RequestMethod.GET)
	public void message(@ModelAttribute("pageHandler") SearchPageHandler pageHandler, Model model) throws Exception {
		logger.info("get : /messageList");
		model.addAttribute("list", service.listSearchPageHandler(pageHandler));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setPageHandler(pageHandler);
		logger.info(pageHandler.toString());
		pageMaker.setTotalCount(service.searchCountPaging(pageHandler));
		logger.info(pageMaker.toString());
		model.addAttribute("pageMaker", pageMaker);
	}
}
