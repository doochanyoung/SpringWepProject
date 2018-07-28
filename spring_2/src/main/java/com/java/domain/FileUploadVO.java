package com.java.domain;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadVO {
	private String imageUrl; 
	private MultipartFile upload; 
	private String filename; 
	private String CKEditorFuncNum;
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getCKEditorFuncNum() {
		return CKEditorFuncNum;
	}
	public void setCKEditorFuncNum(String cKEditorFuncNum) {
		CKEditorFuncNum = cKEditorFuncNum;
	}
	@Override
	public String toString() {
		return "FileUploadVO [imageUrl=" + imageUrl + ", upload=" + upload + ", filename=" + filename
				+ ", CKEditorFuncNum=" + CKEditorFuncNum + "]";
	}
}
