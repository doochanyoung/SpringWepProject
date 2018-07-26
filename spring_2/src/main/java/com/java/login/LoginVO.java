package com.java.login;

public class LoginVO {
	private String userId;
	private String userPassword;
	private String userNickname;
	private String userEmail;
	private String userPhone;
	private String userIntro;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
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
	public String getUserIntro() {
		return userIntro;
	}
	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}
	@Override
	public String toString() {
		return "LoginVO [userId=" + userId + ", userPassword=" + userPassword + ", userNickname=" + userNickname
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userIntro=" + userIntro + "]";
	}
}
