package com.cos.domain;

import com.google.gson.annotations.Expose;

public class Reply {
	
	@Expose
	private int num;
	
	private String content;
	private String userId;
	private int boardNum;
	private String createDate;
	
	public Reply(int num, String content, String userId, int boardNum, String createDate) {

	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

}
