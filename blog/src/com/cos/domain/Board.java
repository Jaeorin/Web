package com.cos.domain;

import java.time.LocalDate;

// VO(Value Object) = table
public class Board {

	private int num; // 시퀀스
	private String title;
	private String content;
	private String userID; // FK
	private int readCount;
	private LocalDate createDate;
	private LocalDate updateDate;

	public Board(int num, String title, String content, String userID, int readCount) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.userID = userID;
		this.readCount = readCount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
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

}