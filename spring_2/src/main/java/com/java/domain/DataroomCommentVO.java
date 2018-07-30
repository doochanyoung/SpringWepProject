package com.java.domain;

import java.util.Date;

public class DataroomCommentVO {
	private int dataroomCommentId;
	private String dataroomCommentContent;
	private int dataroomCommentLike;
	private int dataroomCommentGroup;
	private int dataroomCommentSequence;
	private boolean dataroomCommentIsReply;
	private Date dataroomCommentRegdate;
	private Date dataroomCommentUpdatedate;
	private int dataroomCommentBoardId;
	private String dataroomCommentUserId;
	public int getDataroomCommentId() {
		return dataroomCommentId;
	}
	public void setDataroomCommentId(int dataroomCommentId) {
		this.dataroomCommentId = dataroomCommentId;
	}
	public String getDataroomCommentContent() {
		return dataroomCommentContent;
	}
	public void setDataroomCommentContent(String dataroomCommentContent) {
		this.dataroomCommentContent = dataroomCommentContent;
	}
	public int getDataroomCommentLike() {
		return dataroomCommentLike;
	}
	public void setDataroomCommentLike(int dataroomCommentLike) {
		this.dataroomCommentLike = dataroomCommentLike;
	}
	public int getDataroomCommentGroup() {
		return dataroomCommentGroup;
	}
	public void setDataroomCommentGroup(int dataroomCommentGroup) {
		this.dataroomCommentGroup = dataroomCommentGroup;
	}
	public int getDataroomCommentSequence() {
		return dataroomCommentSequence;
	}
	public void setDataroomCommentSequence(int dataroomCommentSequence) {
		this.dataroomCommentSequence = dataroomCommentSequence;
	}
	public boolean isDataroomCommentIsReply() {
		return dataroomCommentIsReply;
	}
	public void setDataroomCommentIsReply(boolean dataroomCommentIsReply) {
		this.dataroomCommentIsReply = dataroomCommentIsReply;
	}
	public Date getDataroomCommentRegdate() {
		return dataroomCommentRegdate;
	}
	public void setDataroomCommentRegdate(Date dataroomCommentRegdate) {
		this.dataroomCommentRegdate = dataroomCommentRegdate;
	}
	public Date getDataroomCommentUpdatedate() {
		return dataroomCommentUpdatedate;
	}
	public void setDataroomCommentUpdatedate(Date dataroomCommentUpdatedate) {
		this.dataroomCommentUpdatedate = dataroomCommentUpdatedate;
	}
	public int getDataroomCommentBoardId() {
		return dataroomCommentBoardId;
	}
	public void setDataroomCommentBoardId(int dataroomCommentBoardId) {
		this.dataroomCommentBoardId = dataroomCommentBoardId;
	}
	public String getDataroomCommentUserId() {
		return dataroomCommentUserId;
	}
	public void setDataroomCommentUserId(String dataroomCommentUserId) {
		this.dataroomCommentUserId = dataroomCommentUserId;
	}
	@Override
	public String toString() {
		return "dataroomCommentVO [dataroomCommentId=" + dataroomCommentId + ", dataroomCommentContent="
				+ dataroomCommentContent + ", dataroomCommentLike=" + dataroomCommentLike + ", dataroomCommentGroup="
				+ dataroomCommentGroup + ", dataroomCommentSequence=" + dataroomCommentSequence
				+ ", dataroomCommentIsReply=" + dataroomCommentIsReply + ", dataroomCommentRegdate="
				+ dataroomCommentRegdate + ", dataroomCommentUpdatedate=" + dataroomCommentUpdatedate
				+ ", dataroomCommentBoardId=" + dataroomCommentBoardId + ", dataroomCommentUserId="
				+ dataroomCommentUserId + "]";
	}
}
