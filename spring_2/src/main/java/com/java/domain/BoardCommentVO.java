package com.java.domain;

import java.util.Date;

public class BoardCommentVO {
	private int boardCommentId;
	private String content;
	private int like;
	private int group;
	private int sequence;
	private boolean isReply;
	private Date regdate;
	private Date updatedate;
	private String boardId;
	private String userId;
	public int getBoardCommentId() {
		return boardCommentId;
	}
	public void setBoardCommentId(int boardCommentId) {
		this.boardCommentId = boardCommentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public boolean isReply() {
		return isReply;
	}
	public void setReply(boolean isReply) {
		this.isReply = isReply;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "BoardCommentVO [boardCommentId=" + boardCommentId + ", content=" + content + ", like=" + like
				+ ", group=" + group + ", sequence=" + sequence + ", isReply=" + isReply + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + ", boardId=" + boardId + ", userId=" + userId + "]";
	}
}
