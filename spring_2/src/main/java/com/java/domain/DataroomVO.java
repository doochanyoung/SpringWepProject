package com.java.domain;

import java.util.Arrays;
import java.util.Date;

public class DataroomVO {
	private int dataroomId;
	private String dataroomTitle;
	private String dataroomContent;
	private Date dataroomRegdate;
	private Date dataroomUpdatedate;
	private int dataroomHit;
	private int dataroomLike;
	private int dataroomGroup;
	private int dataroomSequence;
	private boolean dataroomIsReply;
	private int dataroomCommCnt;
	private String dataroomUserId;
	private String[] files;
	public int getDataroomId() {
		return dataroomId;
	}
	public void setDataroomId(int dataroomId) {
		this.dataroomId = dataroomId;
	}
	public String getDataroomTitle() {
		return dataroomTitle;
	}
	public void setDataroomTitle(String dataroomTitle) {
		this.dataroomTitle = dataroomTitle;
	}
	public String getDataroomContent() {
		return dataroomContent;
	}
	public void setDataroomContent(String dataroomContent) {
		this.dataroomContent = dataroomContent;
	}
	public Date getDataroomRegdate() {
		return dataroomRegdate;
	}
	public void setDataroomRegdate(Date dataroomRegdate) {
		this.dataroomRegdate = dataroomRegdate;
	}
	public Date getDataroomUpdatedate() {
		return dataroomUpdatedate;
	}
	public void setDataroomUpdatedate(Date dataroomUpdatedate) {
		this.dataroomUpdatedate = dataroomUpdatedate;
	}
	public int getDataroomHit() {
		return dataroomHit;
	}
	public void setDataroomHit(int dataroomHit) {
		this.dataroomHit = dataroomHit;
	}
	public int getDataroomLike() {
		return dataroomLike;
	}
	public void setDataroomLike(int dataroomLike) {
		this.dataroomLike = dataroomLike;
	}
	public int getDataroomGroup() {
		return dataroomGroup;
	}
	public void setDataroomGroup(int dataroomGroup) {
		this.dataroomGroup = dataroomGroup;
	}
	public int getDataroomSequence() {
		return dataroomSequence;
	}
	public void setDataroomSequence(int dataroomSequence) {
		this.dataroomSequence = dataroomSequence;
	}
	public boolean isDataroomIsReply() {
		return dataroomIsReply;
	}
	public void setDataroomIsReply(boolean dataroomIsReply) {
		this.dataroomIsReply = dataroomIsReply;
	}
	public int getDataroomCommCnt() {
		return dataroomCommCnt;
	}
	public void setDataroomCommCnt(int dataroomCommCnt) {
		this.dataroomCommCnt = dataroomCommCnt;
	}
	public String getDataroomUserId() {
		return dataroomUserId;
	}
	public void setDataroomUserId(String dataroomUserId) {
		this.dataroomUserId = dataroomUserId;
	}
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "DataroomVO [dataroomId=" + dataroomId + ", dataroomTitle=" + dataroomTitle + ", dataroomContent="
				+ dataroomContent + ", dataroomRegdate=" + dataroomRegdate + ", dataroomUpdatedate="
				+ dataroomUpdatedate + ", dataroomHit=" + dataroomHit + ", dataroomLike=" + dataroomLike
				+ ", dataroomGroup=" + dataroomGroup + ", dataroomSequence=" + dataroomSequence + ", dataroomIsReply="
				+ dataroomIsReply + ", dataroomCommCnt=" + dataroomCommCnt + ", dataroomUserId=" + dataroomUserId
				+ ", files=" + Arrays.toString(files) + "]";
	}
}
