package com.java.spring2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.domain.BoardCommentVO;
import com.java.domain.PageHandler;
import com.java.domain.PageMaker;
import com.java.service.BoardCommentService;

@RestController
@RequestMapping("/replies")
public class BoardCommentController {

	@Inject
	private BoardCommentService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody BoardCommentVO vo) {
		ResponseEntity<String> entity = null;
		try {
			int maxGroup = service.getMaxGroup(vo.getBoardCommentBoardId());
			service.addComment(vo, maxGroup);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public ResponseEntity<String> registerReply(@RequestBody BoardCommentVO vo) {
		ResponseEntity<String> entity = null;
		try {
			int group = service.getGroup(vo.getBoardCommentId());
			int sequence = service.maxSequence(group);
			service.addCommentReply(vo, group, sequence);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/all/{boardId}", method = RequestMethod.GET)
	public ResponseEntity<List<BoardCommentVO>> list(@PathVariable("boardId") int boardId) {
		ResponseEntity<List<BoardCommentVO>> entity = null;
		try {
			entity = new ResponseEntity<List<BoardCommentVO>>(service.listComment(boardId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<BoardCommentVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{boardCommentId}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("boardCommentId") int boardCommentId,
			@RequestBody BoardCommentVO vo) {
		ResponseEntity<String> entity = null;
		try {
			vo.setBoardCommentId(boardCommentId);
			service.modifyComment(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{boardCommentId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("boardCommentId") int boardCommentId) {
		ResponseEntity<String> entity = null;
		try {
			service.removeComment(boardCommentId);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{boardId}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("boardId") int boardId,
			@PathVariable("page") int page) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			PageHandler pageHandler = new PageHandler();
			pageHandler.setPage(page);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setPageHandler(pageHandler);

			Map<String, Object> map = new HashMap<String, Object>();
			List<BoardCommentVO> list = service.listCommentPage(boardId, pageHandler);

			map.put("list", list);

			int commentCount = service.count(boardId);
			pageMaker.setTotalCount(commentCount);

			map.put("pageMaker", pageMaker);

			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			System.out.println(entity);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String, Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
