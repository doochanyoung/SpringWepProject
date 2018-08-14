package com.java.domain;

public class UserVO {
	private String userId;
	private String userName;
	private String userNickname;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	private int userAdmin;
	private String userIntro;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public int getUserAdmin() {
		return userAdmin;
	}
	public void setUserAdmin(int userAdmin) {
		this.userAdmin = userAdmin;
	}
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userName=" + userName + ", userNickname=" + userNickname
				+ ", userPassword=" + userPassword + ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", userAdmin=" + userAdmin + ", userIntro=" + userIntro + "]";
	}
}
