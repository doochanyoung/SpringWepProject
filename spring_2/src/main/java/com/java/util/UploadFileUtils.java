package com.java.util;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UploadFileUtils {
	private static final Logger logger = LoggerFactory.getLogger(UploadFileUtils.class);
	
	public static String calcPath(String rootPath, String uploadPath) {
		Calendar cal = Calendar.getInstance();
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE)) + File.separator;
		makeDir(rootPath, uploadPath, yearPath, monthPath, datePath);
		logger.info(datePath);
		return datePath;
	}
	
	
	
	private static void makeDir(String rootPath, String uploadPath, String... paths) {
		if(new File(rootPath + uploadPath + paths[paths.length - 1]).exists()) {
			return;
		}
		for(String path : paths) {
			File dirPath = new File(rootPath + uploadPath + path);
			System.out.println(rootPath + uploadPath + path);
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
}
