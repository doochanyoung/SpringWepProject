package com.java.domain;

import java.sql.Date;

public class MessageVO {
	private int messageId;
	private String messageContent;
	private Date messageOpendate;
	private Date messageSendDate;
	private String messageSender;
	private String messageReceiver;
	
	public int getMessageId() {
		return messageId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public Date getMessageOpendate() {
		return messageOpendate;
	}
	public void setMessageOpendate(Date messageOpendate) {
		this.messageOpendate = messageOpendate;
	}
	public Date getMessageSendDate() {
		return messageSendDate;
	}
	public void setMessageSendDate(Date messageSendDate) {
		this.messageSendDate = messageSendDate;
	}
	public String getMessageSender() {
		return messageSender;
	}
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}
	public String getMessageReceiver() {
		return messageReceiver;
	}
	public void setMessageReceiver(String messageReceiver) {
		this.messageReceiver = messageReceiver;
	}
}
