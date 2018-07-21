package com.java.domain;

import java.util.Date;

public class BoardVO {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private Date boardRegdate;
	private Date updatedate;
	private int boardHit;
	private int boardLike;
	private int boardGroup;
	private int boardSequence;
	private boolean isReply;
	private String boardUserId;
	public BoardVO() {};
	public BoardVO(int boardId, String boardTitle, String boardContent, Date boardRegdate, Date updatedate, int boardHit, int boardLike,
			int boardGroup, int boardSequence, boolean isReply, String boardUserId) {
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegdate = boardRegdate;
		this.updatedate = updatedate;
		this.boardHit = boardHit;
		this.boardLike = boardLike;
		this.boardGroup = boardGroup;
		this.boardSequence = boardSequence;
		this.isReply = isReply;
		this.boardUserId = boardUserId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public Date getBoardRegdate() {
		return boardRegdate;
	}
	public void setBoardRegdate(Date boardRegdate) {
		this.boardRegdate = boardRegdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public int getBoardGroup() {
		return boardGroup;
	}
	public void setBoardGroup(int boardGroup) {
		this.boardGroup = boardGroup;
	}
	public int getBoardSequence() {
		return boardSequence;
	}
	public void setBoardSequence(int boardSequence) {
		this.boardSequence = boardSequence;
	}
	public boolean isReply() {
		return isReply;
	}
	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}
	public String getBoardUserId() {
		return boardUserId;
	}
	public void setBoardUserId(String boardUserId) {
		this.boardUserId = boardUserId;
	}
	@Override
	public String toString() {
		return "BoardVO [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardRegdate=" + boardRegdate + ", updatedate=" + updatedate + ", boardHit=" + boardHit
				+ ", boardLike=" + boardLike + ", boardGroup=" + boardGroup + ", boardSequence=" + boardSequence
				+ ", isReply=" + isReply + ", boardUserId=" + boardUserId + "]";
	}
}
