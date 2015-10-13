package com.webapp.board.command;

import com.webapp.board.model.BoardModel;

public class WriteCommand {

	String name;
	String password;
	String subject;
	String content;
	
	
	public BoardModel getBoardModel() {
		BoardModel boardModel = new BoardModel();
		boardModel.setName(this.name);
		boardModel.setPassword(this.password);
		boardModel.setSubject(this.subject);
		boardModel.setContent(this.content);
		return boardModel;
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

}
