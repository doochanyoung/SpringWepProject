package com.java.login;

public class LoginVo {
	private String userId;
	private String userPassword;
	private String nickname;
	private String email;
	private String phone;
	private String intro;
	
	public String getuserId() {
		System.out.println("get userID :: " + userId);
		return userId;
	}
	public void setuserId(String userId) {
		System.out.println("set userID :: " + userId);
		this.userId = userId;
	}
	public String getuserPassword() {
		System.out.println("get userPassword :: " + userPassword);
		return userPassword;
	}
	public void setuserPassword(String userPassword) {
		System.out.println("set userPassword :: " + userPassword);
		this.userPassword = userPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
}
