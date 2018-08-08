package com.java.domain;

import java.util.Arrays;
import java.util.Date;

public class GalleryVO {
	private int galleryId;
	private String galleryTitle;
	private int galleryLike;
	private int galleryHit;
	private Date galleryRegdate;
	private Date galleryUpdatedate;
	private String galleryUserId;
	private String galleryAttachName;
	private String[] files;
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public String getGalleryTitle() {
		return galleryTitle;
	}
	public void setGalleryTitle(String galleryTitle) {
		this.galleryTitle = galleryTitle;
	}
	public int getGalleryLike() {
		return galleryLike;
	}
	public void setGalleryLike(int galleryLike) {
		this.galleryLike = galleryLike;
	}
	public int getGalleryHit() {
		return galleryHit;
	}
	public void setGalleryHit(int galleryHit) {
		this.galleryHit = galleryHit;
	}
	public Date getGalleryRegdate() {
		return galleryRegdate;
	}
	public void setGalleryRegdate(Date galleryRegdate) {
		this.galleryRegdate = galleryRegdate;
	}
	public Date getGalleryUpdatedate() {
		return galleryUpdatedate;
	}
	public void setGalleryUpdatedate(Date galleryUpdatedate) {
		this.galleryUpdatedate = galleryUpdatedate;
	}
	public String getGalleryUserId() {
		return galleryUserId;
	}
	public void setGalleryUserId(String galleryUserId) {
		this.galleryUserId = galleryUserId;
	}
	public String getGalleryAttachName() {
		return galleryAttachName;
	}
	public void setGalleryAttachName(String galleryAttachName) {
		this.galleryAttachName = galleryAttachName;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "GalleryVO [galleryId=" + galleryId + ", galleryTitle=" + galleryTitle + ", galleryLike=" + galleryLike
				+ ", galleryHit=" + galleryHit + ", galleryRegdate=" + galleryRegdate + ", galleryUpdatedate="
				+ galleryUpdatedate + ", galleryUserId=" + galleryUserId + ", files=" + Arrays.toString(files) + "]";
	}
}
