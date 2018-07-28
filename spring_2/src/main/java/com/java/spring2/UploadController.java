package com.java.spring2;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.java.domain.FileUploadVO;

@Controller
public class UploadController {

	@Resource(name = "uploadPath")
	private String uploadPath;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/imageUpload", method = RequestMethod.POST)
	public String ckeditorImageUpload(HttpServletRequest request, FileUploadVO fileUploadVO, Model model) {
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth();
		String monthStr = "";
		
		if(month < 10) monthStr = "0" + month;
		else monthStr = "" + month;
		
		String defaultPath = request.getRealPath("/");
		String contextPath = request.getSession().getServletContext().getContextPath();
		String fileUploadPathTail = "cheImage/" + year + "" + monthStr;
		String fileUploadPath = defaultPath + "/" + fileUploadPathTail;
		
		try {
			MultipartFile file = fileUploadVO.getUpload();
			if(file != null) {
				String fileName = getFileName(file.getOriginalFilename());
				String fileNameExt = fileName.substring(fileName.indexOf(".") + 1);
				if(!"".equals(fileName)) {
					File destD = new File(fileUploadPath);
					if(!destD.exists()) {
						destD.mkdirs();
					}
					File destination = File.createTempFile("ckeditor_", "." + fileNameExt, destD);
					file.transferTo(destination);
					
					fileUploadVO.setFilename(destination.getName());
					fileUploadVO.setImageUrl(fileUploadPath);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUploadVO", fileUploadVO);
		return "/board/imageUploadSuccess";
	}

	private String getFileName(String originalName) throws IOException {
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() + "_" + originalName;
		return savedName;
	}
}
