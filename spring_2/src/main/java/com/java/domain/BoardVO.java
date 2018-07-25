package com.java.domain;

import java.util.Date;

public class BoardVO {
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private Date boardRegdate;
	private Date boardUpdatedate;
	private int boardHit;
	private int boardLike;
	private int boardGroup;
	private int boardSequence;
	private boolean boardIsReply;
	private String boardUserId;
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
	public Date getBoardUpdatedate() {
		return boardUpdatedate;
	}
	public void setBoardUpdatedate(Date boardUpdatedate) {
		this.boardUpdatedate = boardUpdatedate;
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
	public boolean isBoardIsReply() {
		return boardIsReply;
	}
	public void setBoardIsReply(boolean boardIsReply) {
		this.boardIsReply = boardIsReply;
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
				+ ", boardRegdate=" + boardRegdate + ", boardUpdatedate=" + boardUpdatedate + ", boardHit=" + boardHit
				+ ", boardLike=" + boardLike + ", boardGroup=" + boardGroup + ", boardSequence=" + boardSequence
				+ ", boardIsReply=" + boardIsReply + ", boardUserId=" + boardUserId + "]";
	}
}
