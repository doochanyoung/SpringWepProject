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
import com.java.domain.DataroomCommentVO;
import com.java.domain.PageHandler;
import com.java.domain.PageMaker;
import com.java.service.DataroomCommentService;

@RestController
@RequestMapping("/replies2")
public class DataroomCommentController {

	@Inject
	private DataroomCommentService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody DataroomCommentVO vo) {
		ResponseEntity<String> entity = null;
		try {
			int maxGroup = service.getMaxGroup(vo.getDataroomCommentBoardId());
			service.addComment(vo, maxGroup);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

		return entity;
	}

	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public ResponseEntity<String> registerReply(@RequestBody DataroomCommentVO vo) {
		ResponseEntity<String> entity = null;
		try {
			int group = service.getGroup(vo.getDataroomCommentId());
			int sequence = service.maxSequence(group);
			service.addCommentReply(vo, group, sequence);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/all/{dataroomId}", method = RequestMethod.GET)
	public ResponseEntity<List<DataroomCommentVO>> list(@PathVariable("dataroomId") int dataroomId) {
		ResponseEntity<List<DataroomCommentVO>> entity = null;
		try {
			entity = new ResponseEntity<List<DataroomCommentVO>>(service.listComment(dataroomId), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<DataroomCommentVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{dataroomCommentId}", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> update(@PathVariable("dataroomCommentId") int dataroomCommentId,
			@RequestBody DataroomCommentVO vo) {
		ResponseEntity<String> entity = null;
		try {
			vo.setDataroomCommentId(dataroomCommentId);
			service.modifyComment(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{dataroomCommentId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("dataroomCommentId") int dataroomCommentId) {
		ResponseEntity<String> entity = null;
		try {
			service.removeComment(dataroomCommentId);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value = "/{dataroomId}/{page}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("dataroomId") int dataroomId,
			@PathVariable("page") int page) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			PageHandler pageHandler = new PageHandler();
			pageHandler.setPage(page);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setPageHandler(pageHandler);

			Map<String, Object> map = new HashMap<String, Object>();
			List<DataroomCommentVO> list = service.listCommentPage(dataroomId, pageHandler);

			map.put("list", list);

			int commentCount = service.count(dataroomId);
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
