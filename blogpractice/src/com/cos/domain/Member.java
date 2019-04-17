package com.cos.domain;

import java.time.LocalDate;

public class Member {

	private int num;
	private String userId;
	private String userPassword;
	private String userEmail;
	private String userPhone;
	private String userGender;
	private int userState;
	private LocalDate createDate;
	private LocalDate updateDate;

	public Member() {
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

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

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", userId=" + userId + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", userGender=" + userGender + ", userState=" + userState
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + "]";
	}

}