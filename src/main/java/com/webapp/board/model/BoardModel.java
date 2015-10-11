package com.webapp.board.model;

import java.util.Date;

public class BoardModel {

	private int num;			// 글 번호
	private String name;		// 글 작성자 이름
	private String password;	// 글 작성자 비밀번호
	private String subject;		// 글 제목
	private String content;		// 글 내용
	private Date regdate;		// 글 작성일자
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
