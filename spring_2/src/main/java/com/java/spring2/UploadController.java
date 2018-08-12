package com.java.spring2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java.domain.FileUploadVO;
import com.java.service.BoardService;
import com.java.util.MediaUtils;
import com.java.util.UploadFileUtils;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;

	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		logger.info("originalName:" + file.getOriginalFilename());
		return new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}
	
	@ResponseBody
	@RequestMapping(value = "/uploadAjax2", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax2(MultipartFile file) throws Exception {
		logger.info("originalName:" + file.getOriginalFilename());
		String formatName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		if (mType == null) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(
				UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes()),
				HttpStatus.CREATED);
	}


	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		logger.info("FILE NAME : " + fileName);
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName); // �̹��� Ÿ�� �����ΰ�� ������ MIMEŸ���� ����

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);
			/*
			 * if (mType != null) { headers.setContentType(mType); } else { fileName =
			 * fileName.substring(fileName.indexOf("_") + 1);
			 * headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			 * headers.add("Content-Disposition", "attachment; filename=\"" + new
			 * String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\""); }
			 */
			fileName = fileName.substring(fileName.indexOf("_") + 1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping("/displayFile2")
	public ResponseEntity<byte[]> displayFile2(String fileName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

			MediaType mType = MediaUtils.getMediaType(formatName); // �̹��� Ÿ�� �����ΰ�� ������ MIMEŸ���� ����

			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fileName);
			if (mType != null) {
				headers.setContentType(mType);
				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			} else {
				entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}

	@ResponseBody
	@RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName) {
		logger.info("delete file: " + fileName);
		String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
		MediaType mType = MediaUtils.getMediaType(formatName);
		if (mType != null) {
			String front = fileName.substring(0, 12);
			String end = fileName.substring(14);
			new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
		}
		new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/deleteAllFiles", method = RequestMethod.POST)
	public ResponseEntity<String> deleteFile(@RequestParam("files[]") String[] files) {
		logger.info("delete all files: " + files);
		if (files == null || files.length == 0) {
			return new ResponseEntity<String>("deleted", HttpStatus.OK);
		}
		for (String fileName : files) {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
			MediaType mType = MediaUtils.getMediaType(formatName);

			if (mType != null) {
				String front = fileName.substring(0, 12);
				String end = fileName.substring(14);
				new File(uploadPath + (front + end).replace('/', File.separatorChar)).delete();
			}
			new File(uploadPath + fileName.replace('/', File.separatorChar)).delete();
		}
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}

	@RequestMapping(value = "/ckeditorupload3", method = RequestMethod.POST)
	public void fileUpload(@ModelAttribute("fileUploadVO") FileUploadVO fileUploadVO, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		PrintWriter printWriter = null;
		printWriter = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		MultipartFile upload = fileUploadVO.getUpload();
		byte[] fileData = upload.getBytes();
		String CKEditorFuncNum = "";
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + upload.getOriginalFilename(); 
		String savedPath = UploadFileUtils.calcPath(uploadPath);
		String formatName = savedName.substring(savedName.lastIndexOf(".") + 1);
		if(MediaUtils.getMediaType(formatName) == null) {
			printWriter.println("<script type='text/javascript'>alert('you can only select JPG JIF PNG file.');</script>");
			printWriter.flush();
			return;
		}
		String realFileName = "";
		if (upload != null) {
			CKEditorFuncNum = fileUploadVO.getCKEditorFuncNum();
			try {
				File file = new File(uploadPath + savedPath, savedName); 
				FileCopyUtils.copy(fileData, file);
				savedName = UploadFileUtils.makeThumbnail(uploadPath, savedPath, savedName);
				realFileName = savedName.substring(14);
				System.out.println("realFileName :" + realFileName);
				System.out.println("debug : " + savedName);
				fileUploadVO.setFilename(savedName);
				upload.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		savedName = savedName.replaceAll(File.separator + File.separator, "/");
		System.out.println("debug : " + savedName);
		savedName = "/displayFile?fileName=" + savedName.substring(0, 11) + "/" + realFileName;
		printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
               + CKEditorFuncNum
               + ",'"
               + savedName
               + "','upload Success!'"
               + ")</script>");
		printWriter.flush();
	}
}
