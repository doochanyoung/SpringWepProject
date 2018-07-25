package com.java.domain;

import java.util.Date;

public class BoardCommentVO {
	private int boardCommentId;
	private String boardCommentContent;
	private int boardCommentLike;
	private int boardCommentGroup;
	private int boardCommentSequence;
	private boolean boardCommentIsReply;
	private Date boardCommentRegdate;
	private Date boardCommentUpdatedate;
	private int boardCommentBoardId;
	private String boardCommentUserId;
	public int getBoardCommentId() {
		return boardCommentId;
	}
	public void setBoardCommentId(int boardCommentId) {
		this.boardCommentId = boardCommentId;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public int getBoardCommentLike() {
		return boardCommentLike;
	}
	public void setBoardCommentLike(int boardCommentLike) {
		this.boardCommentLike = boardCommentLike;
	}
	public int getBoardCommentGroup() {
		return boardCommentGroup;
	}
	public void setBoardCommentGroup(int boardCommentGroup) {
		this.boardCommentGroup = boardCommentGroup;
	}
	public int getBoardCommentSequence() {
		return boardCommentSequence;
	}
	public void setBoardCommentSequence(int boardCommentSequence) {
		this.boardCommentSequence = boardCommentSequence;
	}
	public boolean isBoardCommentIsReply() {
		return boardCommentIsReply;
	}
	public void setBoardCommentIsReply(boolean boardCommentIsReply) {
		this.boardCommentIsReply = boardCommentIsReply;
	}
	public Date getBoardCommentRegdate() {
		return boardCommentRegdate;
	}
	public void setBoardCommentRegdate(Date boardCommentRegdate) {
		this.boardCommentRegdate = boardCommentRegdate;
	}
	public Date getBoardCommentUpdatedate() {
		return boardCommentUpdatedate;
	}
	public void setBoardCommentUpdatedate(Date boardCommentUpdatedate) {
		this.boardCommentUpdatedate = boardCommentUpdatedate;
	}
	public int getBoardCommentBoardId() {
		return boardCommentBoardId;
	}
	public void setBoardCommentBoardId(int boardCommentBoardId) {
		this.boardCommentBoardId = boardCommentBoardId;
	}
	public String getBoardCommentUserId() {
		return boardCommentUserId;
	}
	public void setBoardCommentUserId(String boardCommentUserId) {
		this.boardCommentUserId = boardCommentUserId;
	}
	@Override
	public String toString() {
		return "BoardCommentVO [boardCommentId=" + boardCommentId + ", boardCommentContent=" + boardCommentContent
				+ ", boardCommentLike=" + boardCommentLike + ", boardCommentGroup=" + boardCommentGroup
				+ ", boardCommentSequence=" + boardCommentSequence + ", boardCommentIsReply=" + boardCommentIsReply
				+ ", boardCommentRegdate=" + boardCommentRegdate + ", boardCommentUpdatedate=" + boardCommentUpdatedate
				+ ", boardCommentBoardId=" + boardCommentBoardId + ", boardCommentUserId=" + boardCommentUserId + "]";
	}
}
